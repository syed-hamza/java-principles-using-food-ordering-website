package com.zoggy.controller;
import com.zoggy.model.Address;
import com.zoggy.model.Cart;
import com.zoggy.model.CartItem;
import com.zoggy.model.User;
import com.zoggy.model.Food;
import com.zoggy.request.AddAddressRequest;
import com.zoggy.request.AddCartItemRequest;
import com.zoggy.request.DeleteAddressRequest;
import com.zoggy.response.cartItemResponse;
import com.zoggy.request.UpdateCartItemRequest;
import com.zoggy.service.CartService;
import com.zoggy.service.AddressService;
import com.zoggy.service.FoodService;
import com.zoggy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Controller
//@RequestMapping("/api")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private FoodService foodService;

    @Autowired
    private UserService userService;

    @Autowired
    private AddressService addressService;

    @DeleteMapping("/delete-address")
    public ResponseEntity<?> deleteAddress(@RequestBody Long id, @RequestHeader("Authorization") String jwt) {
        try {

            User user = userService.findUserByJwtToken(jwt);
            if(user==null){
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No account");
            }
            addressService.deleteAddress(id);

            return ResponseEntity.status(HttpStatus.CREATED).body("Address added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while adding address");
        }
    }

    @GetMapping("/cart-address")
    public ResponseEntity<?> getCartAddresses(@RequestHeader("Authorization") String jwt) {
        try {
            User user = userService.findUserByJwtToken(jwt);
            if(user==null){
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No account");
            }
            List<Address> addresses = addressService.getAddressByUserId(user);
            return ResponseEntity.ok().body(addresses);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while fetching addresses");
        }
    }

    @GetMapping("/get-items")
    public ResponseEntity<?> getCartItems(@RequestHeader("Authorization") String jwt) {
        User user = userService.findUserByJwtToken(jwt);
        if(user==null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No account");
        }
        Cart cart = cartService.findCartByUserId(user.getId());
        List<CartItem> items = cart.getItems();
        cartItemResponse response = new cartItemResponse();
        response.setCartId(cart.getId());
        for (CartItem item : items) {
            System.out.println(item.getId());
            Food food = foodService.findFoodById(item.getFood().getId());
            response.addCartItem(item);
            response.addFood(food);
        }
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/add-address")
    public ResponseEntity<?> addAddress(@RequestBody AddAddressRequest address, @RequestHeader("Authorization") String jwt) {
        try {

            User user = userService.findUserByJwtToken(jwt);
            if(user==null){
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No account");
            }
            addressService.addAddress(address,user.getId());

            return ResponseEntity.status(HttpStatus.CREATED).body("Address added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while adding address");
        }
    }
    @GetMapping("/cart")
    public String cart() {
//        model.addAttribute("message", "Zoggy");
        return "cart"; // Return the name of the Thymeleaf template without the .html extension
    }

    @PostMapping("/cart/add")
    public ResponseEntity<CartItem> addItemToCart(@RequestBody AddCartItemRequest req,
                                                  @RequestHeader("Authorization") String jwt) throws Exception{
        CartItem cartItem=cartService.addItemToCart(req,jwt);
        return new ResponseEntity<>(cartItem, HttpStatus.OK);
    }

    @PutMapping("/cart-item/update")
    public ResponseEntity<CartItem> updateCartItemQuantity(
            @RequestBody UpdateCartItemRequest req,
                                                  @RequestHeader("Authorization") String jwt) throws Exception{
        CartItem cartItem=cartService.updateCartItemQuantity(req.getCartItemId(),req.getQuantity());
        return new ResponseEntity<>(cartItem, HttpStatus.OK);
    }

    @DeleteMapping("/cart-item/{id}/remove")
    public ResponseEntity<Cart> removeCartItem(
            @PathVariable Long id,
            @RequestHeader("Authorization") String jwt) throws Exception{
        Cart cart=cartService.removeItemFromCart(id,jwt);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @PutMapping("/cart/clear")
    public ResponseEntity<Cart> clearCart(

            @RequestHeader("Authorization") String jwt) throws Exception{
        User user=userService.findUserByJwtToken(jwt);
        Cart cart=cartService.clearCart(user.getId());
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @GetMapping("/cart-user")
    public ResponseEntity<Cart> findUserCart(

            @RequestHeader("Authorization") String jwt) throws Exception{
        User user=userService.findUserByJwtToken(jwt);
        Cart cart=cartService.findCartByUserId(user.getId());
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

}
