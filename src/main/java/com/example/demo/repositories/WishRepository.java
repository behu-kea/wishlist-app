package com.example.demo.repositories;


import com.example.demo.models.Wish;
import com.example.demo.utility.DatabaseManager;
import java.sql.*;
import java.util.ArrayList;

public class WishRepository {
    private final Connection conn = DatabaseManager.getConnection();

    public void createWish(Wish wishFromUser, int wishlist) {

        try {
            PreparedStatement createWishQuery = conn.prepareStatement("INSERT INTO wishes(title,link,price,wish_description,fk_wishlist) VALUES(?,?,?,?,?)");
            createWishQuery.setString(1,wishFromUser.getTitle());
            createWishQuery.setString(2,wishFromUser.getLink());
            createWishQuery.setDouble(3,wishFromUser.getPrice());
            createWishQuery.setString(4,wishFromUser.getWishDescription());
            createWishQuery.setInt(5,wishlist);
            createWishQuery.execute();
        }
        catch (SQLException e) {
            System.out.println("Could not create wish");
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Wish> getAllWishes(int wishlistId){
        ArrayList<Wish> wishes = new ArrayList<Wish>();
        Connection conn = DatabaseManager.getConnection();
        try {
            PreparedStatement getAllWishesQuery = conn.prepareStatement("SELECT * FROM wishes WHERE id=(?)");
            ResultSet rs = getAllWishesQuery.executeQuery();

            while(rs.next()){
                Wish tmpWish = new Wish(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getDouble(3),
                    rs.getString(4)
                );
            }
        }
        catch(SQLException e){
            System.out.println("Could not find wishlist with id" + wishlistId);
            System.out.println(e.getMessage());
        }
        return wishes;
    }
}
