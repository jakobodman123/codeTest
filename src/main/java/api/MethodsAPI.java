package api;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.List;
import tasks.*;
import util.UserJsonHandler;

@Path("methods")
public class MethodsAPI {
    static UserJsonHandler jsonUsers = new UserJsonHandler();
    static String users = jsonUsers.getUsers();
    static String reversedUsernames = Methods.reversedUsers(users);


    @GET
    @Path("userswithreversednames")
    public static Response usersWithReversedNames() {
        return Response.ok(
        reversedUsernames
        ).build();
    }

    @POST
    @Path("reversestring")
    public static Response reverseString(@FormParam("string") String string) {
        return Response.ok(
        // response
        ).build();
    }

    @POST
    @Path("ispalindrome")
    public static Response isPalindrome(@FormParam("string") String string) {
        return Response.ok(
        // response
        ).build();
    }

    @POST
    @Path("padnumberwithzeroes")
    public static Response padNumberWithZeroes(@FormParam("number") int number) {
        return Response.ok(
        Methods.formatedNumbers(number)
        ).build();
    }

    @POST
    @Path("findnthlargestnumber")
    public static Response findNthLargestNumber(@FormParam("numbers") List<Integer> numbers,
            @FormParam("nthlargestnumber") int nthLargestNumber) {
        return Response.ok(
        // response
        ).build();
    }

}
