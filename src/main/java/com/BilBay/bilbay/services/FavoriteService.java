package com.BilBay.bilbay.services;

import com.BilBay.bilbay.models.Favorite;
import com.BilBay.bilbay.models.Product;
import com.BilBay.bilbay.models.User;
import com.BilBay.bilbay.repositories.FavoriteRepository;
import com.BilBay.bilbay.repositories.ProductRepository;
import com.BilBay.bilbay.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FavoriteService {
    @Autowired
    private final FavoriteRepository favoriteRepository;
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final ProductRepository productRepository;

    public FavoriteService(FavoriteRepository favoriteRepository,
                           UserRepository userRepository,
                           ProductRepository productRepository) {
        this.favoriteRepository = favoriteRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }


    public Favorite addFavorite(Long user_id, Long product_id) {
        User user = userRepository.findUserById(user_id);
        Product product = productRepository.findProductById(product_id);
        Favorite favorite = new Favorite(user, product);

        return favoriteRepository.save(favorite);
    }

    public Map<User, List<Product>> getAllFavorites() {
        List<Favorite> favorites = favoriteRepository.findAll();

        Map<User, List<Product>> userFavoritesMap = new HashMap<>();

        for (Favorite favorite : favorites) {
            User user = favorite.getUser();
            Product product = favorite.getProduct();

            List<Product> userFavorites = userFavoritesMap.get(user);

            if (userFavorites == null) {
                userFavorites = new ArrayList<>();
                userFavoritesMap.put(user, userFavorites);
            }

            userFavorites.add(product);
        }

        return userFavoritesMap;
    }

    public List<Product> getUsersFavorites(Long id) {
        List<Favorite> favorites = favoriteRepository.findByUserId(id);

        return favorites.stream()
                .map(Favorite::getProduct)
                .toList();
    }
}
