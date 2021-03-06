package fr.davidlegras;

/**
 * TODO
 *
 * @author Lucas David
 * @author Théo Legras
 * @see AbstractOffer
 * @see Discountable
 * @see ProductOffer
 * @see FlashOffer
 */
public abstract class AbstractOffer implements Offer {
    /**
     * Attribut indiquant qu'elle type de client est visée par l'Offer.
     */
    private Class<? extends CustomerState> customerStateClass;
    /**
     * Pourcentage de réduction (e.g. -0.1 ou -0.5 respectivements -10% et -50%).
     */
    private double discount;

    protected AbstractOffer(double discount) throws NotInBoundsDiscountException {
        this(discount, CustomerState.class); /* Concerne par défaut tous les clients. */
    }

    protected AbstractOffer(double discount, Class<? extends CustomerState> customerStateClass) throws NotInBoundsDiscountException {
        super();
        if (discount < -1 || discount > 0)
            throw new NotInBoundsDiscountException("La réduction " + discount * 100 + "% n'est pas comprise entre -100% et 0%.");
        this.discount = discount;
        this.customerStateClass = customerStateClass;
    }

    @Override
    public double discount() {
        return discount;
    }

    @Override
    public boolean applicable(Customer customer, Product product) {
        return customerStateClass.isAssignableFrom(customer.customerState().getClass());
    }

    @Override
    public String toString() {
        return Double.toString(discount * 100) + '%' + (!customerStateClass.equals(CustomerState.class) ? " reservé au " + customerStateClass.getSimpleName() : "");
    }
}
