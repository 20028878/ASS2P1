package vehiclestarter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

 
public class Vehicle {
	private String	manufacturer;
	private String	model;
	private int	makeYear;
        private String  registerationNumber;
        private double OdometerReading;
        private int Tankcapity;
        private Service service;
        private int kmPerLiter;
        private ArrayList<Journey> journies;
        private ArrayList<Rental> rentals;               
	private FuelPurchase	fuelPurchase;
        private boolean Available;

        
	/**
	 * Class constructor specifying name of make (manufacturer), model and year
	 * of make.
	 * @param manufacturer
	 * @param model
	 * @param makeYear
	 */
        public Vehicle(String manufacturer, String model, int makeYear,String registerationNumber,
                int OdometerReading,int tankCapacity,int kmPerLiter) {
		this.manufacturer = manufacturer;
		this.model = model;
		this.makeYear = makeYear;
                this.registerationNumber=registerationNumber;
                this.Tankcapity=tankCapacity;
                this.kmPerLiter=kmPerLiter;
                this.OdometerReading=OdometerReading;                
                service=new Service();
                
                
		fuelPurchase = new FuelPurchase();
                journies=new ArrayList<Journey>();
                rentals=new ArrayList<Rental>();
	}

        public int getFuelEconomyPerLiter() {
            return kmPerLiter;
        }

        public void setFuelEconomyPerLiter(int fuelEconomyPerLiter) {
            this.kmPerLiter = fuelEconomyPerLiter;
        }
        
 
        
        
        public void addJourney(Journey journey){
            journies.add(journey);
            this.addKilometers(journey.getKilometers());
        }
        
        public void addRental(Rental rental){
            rentals.add(rental);
        }
        
        public String getManufacturer() {
            return manufacturer;
        }

        public void setManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public int getMakeYear() {
            return makeYear;
        }

        public void setMakeYear(int makeYear) {
            this.makeYear = makeYear;
        }

        public String getRegisterationNumber() {
            return registerationNumber;
        }

        public void setRegisterationNumber(String registerationNumber) {
            this.registerationNumber = registerationNumber;
        }

        public double getOdometerReading() {
            return OdometerReading;
        }

        public void setOdometerReading(double OdometerReading) {
            this.OdometerReading = OdometerReading;
        }

        public int getTankcapity() {
            return Tankcapity;
        }

        public void setTankcapity(int Tankcapity) {
            this.Tankcapity = Tankcapity;
        }

        public FuelPurchase getFuelPurchase() {
            return fuelPurchase;
        }

        public void setFuelPurchase(FuelPurchase fuelPurchase) {
            this.fuelPurchase = fuelPurchase;
        }
        
        public double revenueEarned(){
            double total=0;
            for(Rental r:rentals){
                total=total+r.getRentalCharge();
            }
            return total;
        }
        
        
        
	/**
	 * Prints details for {@link Vehicle}
	 */
	public void printDetails() {
		System.out.println("Vehicle: " + makeYear + " " + manufacturer + " " + model);		
                System.out.println("Registration No: "+ registerationNumber);
                System.out.println("Total Kilometres Travelled: "+this.OdometerReading);
                System.out.println("Total services: "+this.service.getServiceCount());
                System.out.println("Revenue recorded: "+this.revenueEarned());
                System.out.println("Kilometres since the last service: "+(this.OdometerReading-this.service.getLastServiceOdometerKm()));
                System.out.println("Fuel economy: 10L/"+kmPerLiter*10+"km");
                if(this.OdometerReading-this.service.getLastServiceOdometerKm()>=Service.SERVICE_KILOMETER_LIMIT){
                     System.out.println("Requires a service: Yes ");
                }else{
                    System.out.println("Requires a service: No ");
                }
               

                
	}

        
        // TODO Create an addKilometers method which takes a parameter for distance travelled 
        // and adds it to the odometer reading. 
        public void addKilometers(double km){
            this.OdometerReading+=km;
        }
        // adds fuel to the car
        public void addFuel(double litres, double price){            
            fuelPurchase.purchaseFuel(litres, price);
        }    
        
        public boolean isDueForService(){
            if(this.OdometerReading-this.service.getLastServiceOdometerKm()>=1000){
                return true;
            }else{
                return false;
            }
        } 

        public boolean isAvailable() {
            return Available;
        }

        public void setAvailable(boolean Available) {
            this.Available = Available;
        }
        
        
        public void serviceVehicle(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	LocalDate localDate = LocalDate.now();
        Date today=null;
        try {  
            today=new SimpleDateFormat("dd/MM/yyyy").parse( dtf.format(localDate));
        } catch (ParseException ex) {
            Logger.getLogger(RentalPerDay.class.getName()).log(Level.SEVERE, null, ex);
        }
            this.service.setLastServiceDate(today);
            this.service.recordService((int)this.OdometerReading-this.service.getLastServiceOdometerKm());
  
            
            
        }
        public void printService(){
        
                System.out.println("Total Kilometres Travelled: "+this.OdometerReading);
                System.out.println("Total services: "+this.service.getServiceCount());
                System.out.println("Kilometres since the last service: "+(this.OdometerReading-this.service.getLastServiceOdometerKm()));
                System.out.println("Las service date:"+ this.service.getLastServiceDate().toString());
              
        }
        
        public void printRentals(){
        
            for(Rental r:rentals){
                 System.out.println("********************************************");
                System.out.println(r.toString());
            }
        }
        
    

}
