import static java.lang.IO.println;

void main() {

    UserDTO user = new UserDTO(42L, "dev@example.com");
    ApiResponse<UserDTO> userResponse = ApiResponse.success(user);
    println("User Response: \n" + userResponse);

    println("---");

    // Scenario 2: Returning a List of Products
    List<ProductDTO> products = List.of(
            new ProductDTO("SKU-112", 19.99),
            new ProductDTO("SKU-905", 299.50)
    );
    ApiResponse<List<ProductDTO>> catalogResponse = ApiResponse.success(products);
    println("Catalog Response: \n" + catalogResponse);

    println("---");

    // Scenario 3: Returning a structured Error response
    // Note: You can explicitly declare the expected type, or let type inference handle it.
    ApiResponse<UserDTO> errorResponse = ApiResponse.error("User unauthorized or token expired.");
    println("Error Response: \n" + errorResponse);
}

record UserDTO(Long id, String email) {
}

record ProductDTO(String sku, double price) {
}

static class ApiResponse<T> {
    private final boolean success;
    private final String message;
    private final T data;

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public ApiResponse(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(true, "Operation Successful", data);
    }

    public static <T> ApiResponse<T> error(String errorMessage) {
        return new ApiResponse<>(false, errorMessage, null);
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}