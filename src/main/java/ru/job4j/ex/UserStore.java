package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User user = null;
        for (User u : users) {
            if (u.getUsername().equals(login)) {
                user = u;
                break;
            }
        }
        if (user == null) {
            throw new UserNotFoundException("User was not found");
        }
        return user;
    }

    public static boolean validate(User user) throws UserNotValidException {
        boolean val = user.isValid();
        if (!val || user.getUsername().length() < 3) {
          throw new UserNotValidException("User is not valid");
        }
        return false;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserNotValidException e) {
            System.out.println(e.getMessage());
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
