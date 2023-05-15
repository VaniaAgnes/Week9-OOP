public class SalesPerson {

// each object contains details of one salesperson

    private final String id;

    private final Sales[] salesHistory; // details of the different sales

    private int count = 0; // number of sales made


    //constructor for a new salesperson
    public SalesPerson(String id) {
        this.id = id;
        this.salesHistory = new Sales[100]; // example default size
        this.count = 0;
    }

    // constructor for a salesperson transferred (together with their sales details) from another branch
    public SalesPerson(String id, Sales[] s, int c) {
        this.id = id;
        this.salesHistory = s;
        this.count = c;
    }

    public int getCount() {
        return count;
    }

    public String getId() {
        return id;
    }

    public void setSalesHistory(Sales s) {

        salesHistory[count] = s;

        count = count + 1;

    }

    public Sales getSalesHistory(int index){
        return salesHistory[index];
    }

    // calculate total sales for the salesperson
    public double calcTotalSales() {

        double total = 0.0;
        for (int i = 0; i < count; i++) {
            if (salesHistory[i] != null) //make sure the Sales object is not null
                total = total + salesHistory[i].getValue() * salesHistory[i].getQuantity();
        }
        return total;
    }

    // calculates the sale with the largest value
    public Sales largestSale() {


        double maxSales = 0.0;
        int maxSalesIndex = 0;

        for (int i = 0; i < count; i++) {
            if (salesHistory[i] != null){
                double itemSales = salesHistory[i].getValue() * salesHistory[i].getQuantity();
                if (itemSales > maxSales) {
                    // if the itemSales is larger than current maxSales,
                    // then update the current maxSales value to be equal to itemSales
                    maxSales = itemSales;
                    // store the itemSales index (represent the index where the item sales is the max sales)
                    maxSalesIndex = i;
                }
            }
        }

        return salesHistory[maxSalesIndex];

    }
    public static SalesPerson highest(SalesPerson salesPersons[]) {
        double maxPersonSales = 0.0;
        int maxPersonSalesIndex = 0;
        for (int i = 0; i < salesPersons.length; i++) {
            if (salesPersons[i] != null) {
                double personSales = salesPersons[i].calcTotalSales();

                if (personSales > maxPersonSales) {
                    maxPersonSales = personSales;
                    maxPersonSalesIndex = i;
                }
            }
        }

        return salesPersons[maxPersonSalesIndex];
    }
}