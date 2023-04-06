public class testing {

    private static LMSFacade facade = new LMSFacade();
    public static void main(String[] args) {
        DataLoader.loadUsers();
        facade.getUserList().addUser(new Student("Kelly", "Finnegan", "finnegak@email.sc.edu", "finnegak", "kfinn999!"));
        DataWriter.saveUsers();
    }
}
