package fr.davidlegras.customer;

import fr.davidlegras.Platform;

public class Member implements ConnectedCustomer {
    private String firstName;
    private LoyaltyCard loyaltyCard = new LoyaltyCard();

    public Member(String firstName) {
        super();
        this.firstName = firstName;
    }

    @Override
    public int price(final Platform platform, final Customer context) {
        return 0;
    }

    @Override
    public boolean equals(Object object){
        if(object == null)
            return false;
        if(object == this)
            return true;
        if(object.getClass().equals(this.getClass()))
            return true;
        return false;
    }
}
