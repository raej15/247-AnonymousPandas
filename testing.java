public class testing {

    private static LMSFacade facade = new LMSFacade();
    public static void main(String[] args) {
        facade.getUserList().addUser(new Student("Kelly", "Finnegan", "finnegak@email.sc.edu", "finnegak", "kfinn999!"));
        for (User user: facade.getUserList().getUsers()){
            System.out.println(user.toString());
        }
        System.out.println(facade.getUserList().getUsers().size());
       //DataWriter.saveUsers();
    }
}
