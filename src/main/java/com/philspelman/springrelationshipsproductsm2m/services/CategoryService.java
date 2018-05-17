package com.philspelman.springrelationshipsproductsm2m.services;

import com.philspelman.springrelationshipsproductsm2m.controllers.AlterTable;
import com.philspelman.springrelationshipsproductsm2m.models.Category;
import com.philspelman.springrelationshipsproductsm2m.models.CategoryProduct;
import com.philspelman.springrelationshipsproductsm2m.models.CategoryProductIdentity;
import com.philspelman.springrelationshipsproductsm2m.models.Product;
import com.philspelman.springrelationshipsproductsm2m.repositories.CategoryProductRepository;
import com.philspelman.springrelationshipsproductsm2m.repositories.CategoryRepository;
import com.philspelman.springrelationshipsproductsm2m.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.Optional;

//import com.philspelman.springrelationshipsproductsm2m.repositories.CategoryProductJPARepo;


@Service
public class CategoryService {
    //hook up repo
    private CategoryRepository categoryRepository;
    private final CategoryProductRepository categoryProductRepository;
    private final ProductRepository productRepository;


    public CategoryService(CategoryRepository categoryRepository,
                           CategoryProductRepository categoryProductRepository,
                           ProductRepository productRepository
//                           CategoryProductJPARepo categoryProductJPARepo
    ) {

        this.categoryRepository = categoryRepository;
        this.categoryProductRepository = categoryProductRepository;
        this.productRepository = productRepository;
//        CategoryProductJPARepo categoryProductJPARepo1 = categoryProductJPARepo;

        if (this.productRepository.findAll().size() < 1) {
            addNewProducts();
            addNewCategories();
            try {
                System.out.println("trying to change the tables");
                AlterTable alterTable = new AlterTable();
                alterTable.setPks();

//                categoryProductRepository.changeTables();

//                categoryProductJPARepo1.changeTables();

            } catch (Exception error) {
                System.out.println("Error! Couldn't change the tables");

            }

            //add some new categories

        }
    }

    private void addNewProducts() {
        this.productRepository.save(new Product("Shoe", "Nike", 50));
        this.productRepository.save(new Product("Turtle", "A ninja", 10));
        this.productRepository.save(new Product("Hammer", "A way to tell time", 2));

    }

    private void addNewCategories() {
        this.categoryRepository.save(new Category("bags"));
        this.categoryRepository.save(new Category("hats"));
        this.categoryRepository.save(new Category("electronics"));

    }

    public void addCategory(Category category) {
        this.categoryRepository.save(category);

        if (this.categoryRepository.findAll().size() < 1) {
            //make some new categories
        }
    }

//    public void associateProductWithCategory(Product product, Category category) {
    public void associateProductWithCategory(Long product_id, Long category_id) {


        Optional<Product> product = productRepository.findById(product_id);
        Optional<Category> category = categoryRepository.findById(category_id);

        //FIXME: for now, this will test the existence of the relationship, and NOT add it if it already exists

        if (category.isPresent() && product.isPresent()) {
            System.out.println("category: " + category.get());
            System.out.println("Product: " + product.get());

            //see if this relationship exists in DB
//            Boolean exists = categoryProductRepository.findByCategoryAndAndProduct(category.get(), product.get());

            CategoryProductIdentity association = new CategoryProductIdentity(category.get().getId(), product.get().getId());


            CategoryProduct new_association = new CategoryProduct(product.get(), category.get());


            System.out.println("new association: " + new_association);


            try {
                categoryProductRepository.save(new_association);
            } catch (Exception error) {
                System.out.println("Error!");

            }

            List<CategoryProduct> sample_list = categoryProductRepository.findCategoryProductByProductEquals(product.get());

            iterateCategoryProductResults(sample_list);


        }

    }
    //todo: pull all categories

    //todo: pull all categories NOT on a list

    private static void iterateCategoryProductResults(List<CategoryProduct> catProd) {
        for (Object object : catProd) {
            if(object instanceof CategoryProduct) {
                CategoryProduct post = (CategoryProduct) object;
                System.out.println(post.toString());
            }
            if(object instanceof ObjectError) {
                ObjectError objectError = (ObjectError) object;
                System.out.println(objectError.getCode());
            }
        }
    }

    public void destroyCategory(Long id) {
        //try to destroy the category
    }

    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    public List<Category> allCategories() {
        return categoryRepository.findAll();
    }
}
//execute table modification
//            SessionFactory sessionFactory = new SessionFactory();
//            Session session = sessionFactory.getCurrentSession()
//
//            factory.openSession();
//            Session session = factory.getCurrentSession();
//            Transaction tx=session.beginTransaction();
//
//            Query query=session.createSQLQuery("ALTER TABLE ZeeCallSp AUTO_INCREMENT = 1");
//            query.executeUpdate();
//            tx.commit();
//            session.close();
