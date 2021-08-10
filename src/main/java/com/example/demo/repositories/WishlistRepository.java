package com.example.demo.repositories;

import com.example.demo.models.Wishlist;
import com.example.demo.utility.DatabaseManager;

import java.sql.*;
import java.util.ArrayList;

public class WishlistRepository {
    private final Connection databaseConnection = DatabaseManager.getConnection();

    public void createWishlist(String title) {
        try {
            PreparedStatement createWishListQuery =  DatabaseManager.getConnection().prepareStatement("INSERT INTO wishlists (title) VALUES (?)");
            createWishListQuery.setString(1,title);
            createWishListQuery.execute();
        }

        catch(SQLException e){
            System.out.println("Could not create wishlist");
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Wishlist> getAllWishLists(){
        ArrayList<Wishlist> allWishlists = new ArrayList<Wishlist>();
        try {
            PreparedStatement getAllWishListsQuery = databaseConnection.prepareStatement("SELECT * FROM wishlists");
            ResultSet rs = getAllWishListsQuery.executeQuery();
            while(rs.next()){
                Wishlist tmp = new Wishlist(
                        rs.getInt(1),
                        rs.getString(2)
                );
                allWishlists.add(tmp);
            }
        }

        catch(SQLException e){
            System.out.println("Could not fetch all wish lists");
            System.out.println(e.getMessage());
        }
        return allWishlists;
    }

    public Wishlist getSingleWishlistById(int id) {
        Wishlist wishlist = null;
        try {
            PreparedStatement getSingleWishlistQuery = databaseConnection.prepareStatement("SELECT * FROM wishlists WHERE id=(?)");
            getSingleWishlistQuery.setInt(1,id);
            ResultSet rs = getSingleWishlistQuery.executeQuery();
            while(rs.next()){
                int wishlistId = rs.getInt(1);
                wishlist = new Wishlist(
                        rs.getString(2)
                );
            }
        }
        catch(SQLException e){
            System.out.println("Could not find wishlist");
            System.out.println(e.getMessage());
        }
        return wishlist;
    }
}
