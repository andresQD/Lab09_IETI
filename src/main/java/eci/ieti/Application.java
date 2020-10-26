package eci.ieti;

import eci.ieti.data.CustomerRepository;
import eci.ieti.data.ProductRepository;
import eci.ieti.data.TodoRepository;
import eci.ieti.data.UserRepository;
import eci.ieti.data.config.AppConfiguration;
import eci.ieti.data.model.Customer;
import eci.ieti.data.model.Product;
import eci.ieti.data.model.Todo;
import eci.ieti.data.model.User;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        customerRepository.deleteAll();

        customerRepository.save(new Customer("Alice", "Smith"));
        customerRepository.save(new Customer("Bob", "Marley"));
        customerRepository.save(new Customer("Jimmy", "Page"));
        customerRepository.save(new Customer("Freddy", "Mercury"));
        customerRepository.save(new Customer("Michael", "Jackson"));

        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");

        customerRepository.findAll().stream().forEach(System.out::println);
        System.out.println();

        productRepository.deleteAll();

        productRepository.save(new Product(1L, "Samsung S8", "All new mobile phone Samsung S8"));
        productRepository.save(new Product(2L, "Samsung S8 plus", "All new mobile phone Samsung S8 plus"));
        productRepository.save(new Product(3L, "Samsung S9", "All new mobile phone Samsung S9"));
        productRepository.save(new Product(4L, "Samsung S9 plus", "All new mobile phone Samsung S9 plus"));
        productRepository.save(new Product(5L, "Samsung S10", "All new mobile phone Samsung S10"));
        productRepository.save(new Product(6L, "Samsung S10 plus", "All new mobile phone Samsung S10 plus"));
        productRepository.save(new Product(7L, "Samsung S20", "All new mobile phone Samsung S20"));
        productRepository.save(new Product(8L, "Samsung S20 plus", "All new mobile phone Samsung S20 plus"));
        productRepository.save(new Product(9L, "Samsung S20 ultra", "All new mobile phone Samsung S20 ultra"));

        System.out.println("Paginated search of products by criteria:");
        System.out.println("-------------------------------");

        productRepository.findByDescriptionContaining("plus", PageRequest.of(0, 3)).stream()
                .forEach(System.out::println);

        System.out.println("Todo");
        SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
        todoRepository.deleteAll();
        todoRepository.save(new Todo("travel to Galapagos", 10, ft.parse("01-10-1860"), "charles@natural.com", "pending"));
        todoRepository.save(new Todo("Viaje al espacio", 10, ft.parse("15-2-1862"), "einstein@fisica.com", "pending"));
        todoRepository.save(new Todo("Viaje cartagena", 5, ft.parse("31-10-2020"), "carlos@mail.com", "ok"));
        todoRepository.save(new Todo("Viaje Barranquilla", 3, ft.parse("25-12-2020"), "carlos@mail.com", "ok"));
        todoRepository.save(new Todo("Viaje Bucaramanga", 7, ft.parse("25-9-2020"), "luis@mail.com", "ok"));
        todoRepository.save(new Todo("Viaje Neiva", 8, ft.parse("12-10-2020"), "luis@fisica.mail", "ok"));
        todoRepository.save(new Todo("Viaje Boyaca", 8, ft.parse("25-7-2019"), "nicolas@mail.com", "ok"));
        todoRepository.save(new Todo("Viaje Medellin", 10, ft.parse("20-10-2018"), "nicolas@mail.com", "pending"));
        todoRepository.save(new Todo("Viaje Pereira", 9, ft.parse("25-12-2020"), "andres@mail.com", "ok"));
        todoRepository.save(new Todo("Viaje Cali", 8, ft.parse("20-12-2020"), "andres@mail.com", "ok"));
        todoRepository.save(new Todo("Viaje Cartago", 10, ft.parse("5-12-2020"), "daniel@mail.com", "pending"));
        todoRepository.save(new Todo("Viaje San Andres", 10, ft.parse("15-6-2020"), "daniel@mail.com", "ok"));
        todoRepository.save(new Todo("Viaje Pasto", 3, ft.parse("2-12-2020"), "paula@mail.com", "pending"));
        todoRepository.save(new Todo("Viaje Cucuta", 1, ft.parse("25-3-2021"), "paula@mail.com", "pending"));
        todoRepository.save(new Todo("Viaje Choco", 2, ft.parse("25-11-2021"), "laura@mail.com", "pending"));
        todoRepository.save(new Todo("Viaje Santa Marta", 7, ft.parse("27-11-2020"), "laura@mail.com", "pending"));
        todoRepository.save(new Todo("Viaje Llanos Orientales prueba para el ultimo query mayor a 30 caracteres", 4, ft.parse("9-3-2021"), "einstein@fisica.com", "pending"));
        todoRepository.save(new Todo("Viaje Fusa", 6, ft.parse("2-12-2022"), "ana@mail.com", "pending"));
        todoRepository.save(new Todo("Viaje Chia", 8, ft.parse("17-8-2020"), "ana@mail.com", "ok"));
        todoRepository.save(new Todo("Viaje Cajica", 9, ft.parse("31-7-2020"), "ana@mail.com", "pending"));

        System.out.println("Todo found with findAll():");
        todoRepository.findAll().forEach(System.out::println);
        System.out.println("Paginated search of todos by criteria:");
        System.out.println("-------------------------------");
        todoRepository.findByResponsibleContaining("einstein@fisica.com", PageRequest.of(0, 2)).stream().forEach(System.out::println);

        System.out.println("User");
        userRepository.deleteAll();
        userRepository.save(new User("12345", "Charles Darwin", "charles@natural.com"));
        userRepository.save(new User("123456", "Albert Einstein", "einstein@fisica.com"));
        userRepository.save(new User("1234567", "Carlos", "ecarlos@mail.com"));
        userRepository.save(new User("12345678", "Luis", "luis@mail.com"));
        userRepository.save(new User("123456789", "Nicolas", "nicolas@mail.com"));
        userRepository.save(new User("1234567890", "Andres", "andres@mail.com"));
        userRepository.save(new User("12345678901", "Daniel", "daniel@mail.com"));
        userRepository.save(new User("123456789012", "Paula", "paula@mail.com"));
        userRepository.save(new User("1234567890123", "Laura", "laura@mail.com"));
        userRepository.save(new User("12345678901234", "Ana", "ana@mail.com"));

        System.out.println("Users found with findAll():");
        userRepository.findAll().forEach(System.out::println);

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
        MongoOperations mongoOperation = (MongoOperations) applicationContext.getBean("mongoTemplate");

        Query query = new Query();
        query.addCriteria(Criteria.where("firstName").is("Alice"));

        Customer customer = mongoOperation.findOne(query, Customer.class);
        System.out.println("-------------------------------");
        System.out.println("Result Mongo Operation");
        System.out.println(customer);

        //Querys
        Query q1 = new Query();
        q1.addCriteria(Criteria.where("dueDate").lte(new Date()));
        List<Todo> expirados = mongoOperation.find(q1, Todo.class);
        System.out.println("Todos expirados");
        System.out.println(expirados);

        Query q2 = new Query();
        q2.addCriteria(Criteria.where("responsible").is("laura@mail.com"));
        q2.addCriteria(Criteria.where("priority").gte(5));
        List<Todo> todo2 = mongoOperation.find(q2, Todo.class);
        System.out.println("dado usuario y prioridad mayor o igual a 5");
        System.out.println(todo2);

        userRepository.findAll().stream().forEach(user -> {
            Query q3 = new Query();
            q3.addCriteria(Criteria.where("responsible").is(user.getEmail()));
            if (mongoOperation.find(q3, Todo.class).size() > 2) {
                System.out.println("Usuario con mas de 2 todos");
                System.out.println(user);
            }
        });
        
        Query q4 = new Query();
        q4.addCriteria(Criteria.where("description").regex(".{30,}"));
        List<Todo> td = mongoOperation.find(q4, Todo.class);
        System.out.println("Todos con mas de 30 caracteres de descripcion ");
        System.out.println(td);
        
    }

}
