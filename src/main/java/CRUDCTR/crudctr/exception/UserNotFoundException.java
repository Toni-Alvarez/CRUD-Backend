package CRUDCTR.crudctr.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long Id){
    super("Could not found the user with Id"+ Id);

    }
}
