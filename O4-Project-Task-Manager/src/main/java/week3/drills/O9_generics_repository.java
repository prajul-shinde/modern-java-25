import static java.lang.IO.println;

void main() {

    println("=== USER REPOSITORY ===");
    Repository<User> userRepository = new Repository<>();

    userRepository.save(new User(1L, "alice_dev"));
    userRepository.save(new User(2L, "bob_design"));

    println("Find ID 1: " + userRepository.findById(1L));
    println("All Users: " + userRepository.findAll());

    userRepository.delete(1L);
    println("All Users after delete: " + userRepository.findAll());

    println();

    // --- 2. Testing Product Repository ---
    System.out.println("=== PRODUCT REPOSITORY ===");
    Repository<Product> productRepository = new Repository<>();

    productRepository.save(new Product(101L, "Mechanical Keyboard", 120.00));
    productRepository.save(new Product(102L, "Wireless Mouse", 80.00));

    println("Find ID 102: " + productRepository.findById(102L));
    println("All Products: " + productRepository.findAll());

    // Compile-time safety proof:
//     userRepository.save(new Product(103L, "Laptop", 1000.00));
    // ^ The line above would cause a compilation error!
}

class BaseEntity {
    private Long id;

    public BaseEntity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

// Entity Type 1: User
class User extends BaseEntity {
    private String username;

    public User(Long id, String username) {
        super(id);
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{id=" + getId() + ", username='" + username + "'}";
    }
}

// Entity Type 2: Product
class Product extends BaseEntity {
    private String name;
    private double price;

    public Product(Long id, String name, double price) {
        super(id);
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{id=" + getId() + ", name='" + name + "', price=$" + price + "}";
    }
}

class Repository<T extends BaseEntity> {

    private final Map<Long, T> database = new HashMap<>();

    void save(T entity) {
        if (entity != null && entity.getId() != null) {
            database.put(entity.getId(), entity);
            println("Saved entity with id %d".formatted(entity.getId()));
        }
    }

    T findById(Long id) {
        return database.get(id);
    }

    List<T> findAll() {
        return new ArrayList<>(database.values());
    }

    public void delete(Long id) {
        if (database.containsKey(id)) {
            database.remove(id);
            System.out.println("Deleted entity with ID: " + id);
        } else {
            System.out.println("Entity with ID " + id + " not found.");
        }
    }
}