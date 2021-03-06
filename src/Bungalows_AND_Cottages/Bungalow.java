package Bungalows_AND_Cottages;
import java.text.DecimalFormat;

/**
 * class Bungalow extends Booking
 * @author Aimi Ross
 * @version 1.0.0
 * @since 10/28/2019
 * **/

public class Bungalow extends Booking{
	double optionPrice = 20;
	double typePrice;
	int optionNights;
	
	/**
	 * default constructor
	 */
	public Bungalow() {}
	
	/**
	  * constructor Bungalow
	  * @param n: name
	  * @param c: amount of guest 
	  * @param from: check-in
	  * @param nyt: nights counts
	  * @param bungType: Bungalow's name
	  * @param addss: address
	  * @param phn: phone
	  * @param e: email
	  * @param cName: name of credit card
	  * @param cNum: number of credit card
	  * @param eDate: Expiration date of credit card
	  * @param sCode: Security code of credit card
	  * @param i: confirmation number
	  * @param typeP: Price of picked type
	  * @param optNyts: days for the option
	 */
	public Bungalow(String n, String c, String from, int nights, String pickedBung,String addss, String phn, String e, String cName, String cNum, String eDate, String sCode, int i, double typeP,  int optNyts) {
		super(n,c,from, nights,pickedBung, addss,phn,e,cName,cNum,eDate,sCode, i);
		this.typePrice = typeP;
		this.optionNights = optNyts;
	}

	/**
	 * booking info to string
	 */
	public String toString() {
		DecimalFormat depo = new DecimalFormat();
		depo.setMinimumFractionDigits(2);
		
		return "\nConfirmation Number: " + confirmationNumber + "\nType:\t\t" + type + "\nFrom:\t\t" 
				+ dateFrom + "\nNight(s):\t"+ nights + " nights\nName:\t\t" + name + "\nGuest(s):\t" + count + "\nCard info:\t" + cardName + " " 
				+ cardNum + " " + expDate + " " + seruciryCode + "\nTotal:\t\t(" + typePrice + " x " + nights + ") "
				+ "+ (" + optionPrice +" x " + optionNights +") = $" + depo.format(((typePrice*nights)+(optionPrice*optionNights)))
				+ "\nDeposit(20%):\t$" + depo.format(((typePrice*nights)+(optionPrice*optionNights))*0.20)
				+ "\nOwes(80%):\t$"+ depo.format(((typePrice*nights)+(optionPrice*optionNights))*0.80);
		}
	
	/**
	 * setter
	 * @param n: option nights
	 */
	public void setOption(int n) {
		this.optionNights = n;
	}
	
	/**
	 * displaying option
	 */
	@Override
	public void displayOption() {
		System.out.println("Option: A portable AC rental for $20 / night");
		System.out.print("How many nights would you like to have the option?: ");
	}
	
	/**
	 * displaying deposit status
	 */
	public void displayDeposit() {
		DecimalFormat depo = new DecimalFormat();
		depo.setMinimumFractionDigits(2);
		System.out.println("Deposit is fully refundable.");
		System.out.println("Refund: $" + depo.format(((typePrice*nights)+(optionPrice*optionNights))*0.2));
	}
	
}
