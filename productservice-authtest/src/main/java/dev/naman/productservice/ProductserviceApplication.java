package dev.naman.productservice;

import dev.naman.productservice.inheritancedemo.joinedtable.Mentor;
import dev.naman.productservice.inheritancedemo.joinedtable.MentorRepository;
import dev.naman.productservice.inheritancedemo.joinedtable.User;
import dev.naman.productservice.inheritancedemo.joinedtable.UserRepository;
import dev.naman.productservice.models.Category;
import dev.naman.productservice.models.Price;
import dev.naman.productservice.models.Product;
import dev.naman.productservice.repositories.CategoryRepository;
import dev.naman.productservice.repositories.PriceRepository;
import dev.naman.productservice.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class ProductserviceApplication implements CommandLineRunner {

    private MentorRepository mentorRepository;


    private UserRepository userRepository;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final PriceRepository priceRepository;

    public ProductserviceApplication(@Qualifier("jt_mr") MentorRepository mentorRepository,
                                     @Qualifier("jt_ur") UserRepository userRepository,
                                     ProductRepository productRepository,
                                     CategoryRepository categoryRepository,
                                     PriceRepository priceRepository) {
        this.mentorRepository = mentorRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.priceRepository = priceRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProductserviceApplication.class, args);
    }

    @Transactional()
    @Override
    public void run(String... args) throws Exception {
        Mentor mentor = new Mentor();
        mentor.setName("Naman");
        mentor.setEmail("Naman@scaler.com");
        mentor.setAverageRating(4.65);
        mentor = mentorRepository.save(mentor);

        User user = new User();
        user.setName("Sarath");
        user.setEmail("sarathcool@yopmail.com");
        user = userRepository.save(user);

        List<User> users = userRepository.findAll();
        for (User user1: users) {
            System.out.println(user1);
        }

        Category category = new Category();
        category.setName("Apple Devices");
        category = categoryRepository.save(category);

        Price price = new Price("Rupee", 10);
        price = priceRepository.save(price);

        System.out.println("All products:");
        productRepository.findAll().forEach(x -> System.out.println(x.getTitle()));

        productRepository.deleteAll();

        System.out.println("After deletion : All products:");
        productRepository.findAll().forEach(x -> System.out.println(x.getTitle()));

        Product product1 = new Product();
        product1.setTitle("iPhone 10");
        product1.setDescription("Old iPhone");
        product1.setCategory(category);
        product1.setPrice(price);
        product1 = productRepository.save(product1);

        Product product2 = new Product();
        product2.setTitle("iPhone 11");
        product2.setDescription("The latest iPhone");
        product2.setCategory(category);
        product2.setPrice(price);

        product2 = productRepository.save(product2);
        System.out.println("After re-adding new All products:");
        productRepository.findAll().forEach(x -> System.out.println(x.getTitle()));

        System.out.println("Number of products with currency Rupee: " + productRepository.countAllByPrice_Currency("Rupee"));
        Category category1 = categoryRepository.findAll().get(0);
        System.out.println("Category name is: " + category1.getName());
        System.out.println("Printing all products in the category");

        category1.getProducts().forEach(
                product -> System.out.println(product.getTitle())
        );
    }

}
