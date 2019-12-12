package vehiclestarter;

public class FuelPurchase {
        private double litres = 0;
        private double cost = 0;

	public double getFuelEconomy() {
            return this.cost / this.litres;
	}
        
        public double getFuel(){
            return this.litres;
        }

        public double getCost() {
            return cost;
        }

       


        public void purchaseFuel(double amount,double price){
            this.litres += amount;
            this.cost += price;
        }
}
