import DataController.*;

public class Main {
	public static void main(String[] args) {
		// DBConnector.Connect();
	
		//DataAdder.AddManager("Kamyab", "Tabani", "CyberGhost", "HAT_Cyber", "0914655912", "K.tabani82@gmail.com");
		//DataAdder.AddEmployee("Puya", "Afraz", "P.A", "VLB", 1, "09148303766", "Pouyaafraz@gmail.com", "E-0001");
		//DataAdder.AddCustomer("MohammadMahdi", "Hejazi", "M.M.H", "M.M.H Lego", "09144571245", "mmhlego@gmail.com", "Sahand - kuye sahanad", 0, 1, "C-0001");
		// System.out.println(DataChecker.UserExists("CyberGhost"));
		// DataAdder.AddProduct("Samsung Galaxy A51", "Samsung", "Nothing", 10000000, 10, "Phone", 5, "P-0001");
		// System.out.println(DataChecker.GetAmountOf("Manager"));

		DBConnector.CreateTimer();
		
	}
}
