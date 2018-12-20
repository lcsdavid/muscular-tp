import fr.davidlegras.customer.CustomerListener;

public interface Plateform {






    Server server();

    interface Server {

        void onConnect(String login, String passwordHash);

        void onDisconnect();





    }

    void addCustomerListener(CustomerListener listener);

    void removeCustomerListener(CustomerListener listener);

}