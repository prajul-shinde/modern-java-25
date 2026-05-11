void main() {

    Dog myDog = new Dog();

    // No cast needed!
    // Even though the parent says it returns Animal,
    // the compiler knows Dog.reproduce() specifically returns a Dog.
    Dog puppy = myDog.reproduce();

    puppy.bark(); // Works immediately
}

class Animal {
    public Animal reproduce() {
        System.out.println("Animal is reproducing...");
        return new Animal();
    }
}

class Dog extends Animal {
    @Override
    // Returning 'Dog' instead of 'Animal' (Covariance)
    public Dog reproduce() {
        System.out.println("Dog is reproducing puppies...");
        return new Dog();
    }

    public void bark() {
        System.out.println("Woof!");
    }
}