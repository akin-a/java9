import java.util.List;

public class ImmutableCollections {

    public static void main(String[] args) {

        immutableList();
    }

    /**
     * Method to create an immutable list, and try to modify it to catch error.
     */
    private static void immutableList() {
        List<String> testList = List.of("1", "2", "3");
        System.out.println(testList.getFirst());

        try{
            testList.add("23");
        } catch(UnsupportedOperationException e){
            System.out.println("Ouch, You can not edit an immutable list");
        }
    }
}

