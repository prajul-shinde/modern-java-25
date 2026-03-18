void main() {

    UserRepository repo = new UserRepository();
    repo.save(new User("U001", "Alice"));

    List<User> batch = List.of(new User("U002", "Bob"), new User("U003", "Charlie"));
    repo.saveAll(batch);

    repo.findById("U001").ifPresent(u -> System.out.println("Found: " + u));
    System.out.println("All users: " + repo.findAll());

    List<Entity> entities = new ArrayList<>();
    repo.copyTo(entities);
    System.out.println("Copied to entity list: " + entities.size() + " entities");
}

interface Entity {

    String getId();
}

interface Repository<T extends Entity> {

    void save(T entity);

    Optional<T> findById(String id);

    List<T> findAll();

    void saveAll(List<? extends T> entities);

    void copyTo(List<? super T> destination);
}

record User(String id, String name) implements Entity {
    @Override
    public String getId() {
        return id;
    }
}

class UserRepository implements Repository<User> {

    private Map<String, User> store = new HashMap<>();

    @Override
    public void save(User entity) {
        store.put(entity.id(), entity);
    }

    @Override
    public Optional<User> findById(String id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void saveAll(List<? extends User> entities) {
        entities.forEach(this::save);
    }

    @Override
    public void copyTo(List<? super User> destination) {
        destination.addAll(store.values());
    }
}