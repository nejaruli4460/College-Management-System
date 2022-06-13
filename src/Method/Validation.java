package Method;

import javax.swing.JOptionPane;

public class Validation {
	public static boolean stringContainsDigit(String str) {
		char []arr=str.toCharArray();
		boolean flag=false;
		for(int i=0;i<arr.length;i++) {
			if(Character.isDigit(arr[i])) {
				flag=true;
				break;
			}else {
				flag=false;
			}
		}
		return flag;
		
	}
	public static boolean stringContainsString(String str) {
		char []arr=str.toCharArray();
		boolean flag=false;
		for(int i=0;i<arr.length;i++) {
			if(Character.isDigit(arr[i])) {
				flag=true;
			}else {
				flag=false;
				break;
			}
		}
		return flag;
		
	}
	public static boolean departmentValid(String dcode,String dname,String seatArea) {
		boolean flag=false;
		if(dcode.length()<3) {
			JOptionPane.showMessageDialog(null, "Enter Valid department code","Error",JOptionPane.ERROR_MESSAGE);
			return false;
		}else if(stringContainsDigit(dcode)==true) {
			JOptionPane.showMessageDialog(null, "0 to 9 in between department code","Error",JOptionPane.ERROR_MESSAGE);
			return false;
		}else if(dcode.startsWith(" ")) {
			JOptionPane.showMessageDialog(null, "department code can not start with space","Error",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if(dname.length()<3) {
			JOptionPane.showMessageDialog(null, "Enter Valid name","Error",JOptionPane.ERROR_MESSAGE);
			return false;
		}else if(stringContainsDigit(dname)==true) {
			JOptionPane.showMessageDialog(null, "0 to 9 in between name","Error",JOptionPane.ERROR_MESSAGE);
			return false;
		}else if(dname.startsWith(" ")) {
			JOptionPane.showMessageDialog(null, "department name can not start with space","Error",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if(seatArea.equals("")) {
			JOptionPane.showMessageDialog(null, "seat number field can't empty","Error",JOptionPane.ERROR_MESSAGE);
			return false;
		}else if(seatArea.startsWith(" ")) {
			JOptionPane.showMessageDialog(null, "seat number cant start with space","Error",JOptionPane.ERROR_MESSAGE);
			return false;
		}else if(stringContainsString(seatArea)==false) {
			JOptionPane.showMessageDialog(null, "seat number only can occupied with number","Error",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if(seatArea.length()>3||Integer.parseInt(seatArea)<=0 || Integer.parseInt(seatArea)>=200) {
			JOptionPane.showMessageDialog(null, "seat number range between 1 to 200","Error",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else {
			return true;
		}
	
	}
	public static boolean nameFieldChecking(String name,String field) {
		if(name.length()<3) {
			JOptionPane.showMessageDialog(null, "Enter Valid "+field,"Error",JOptionPane.ERROR_MESSAGE);
			return false;
		}else if(stringContainsDigit(name)==true) {
			JOptionPane.showMessageDialog(null, "0 to 9 in between "+field,"Error",JOptionPane.ERROR_MESSAGE);
			return false;
		}else if(name.startsWith(" ")) {
			JOptionPane.showMessageDialog(null, field+" can not start with space","Error",JOptionPane.ERROR_MESSAGE);
			return false;
		}else {
			return true;
		}

	}
	public static boolean addressFieldChecking(String name,String field) {
		if(name.length()<5) {
			JOptionPane.showMessageDialog(null,field+ "character length must be greater than 5 ","Error",JOptionPane.ERROR_MESSAGE);
			return false;
		}else if(name.startsWith(" ")) {
			JOptionPane.showMessageDialog(null, field+" can not start with space","Error",JOptionPane.ERROR_MESSAGE);
			return false;
		}else {
			return true;
		}

	}

	public static boolean pincodeChecking(String pin) {
		if(Validation.stringContainsString(pin)==false) {
			JOptionPane.showMessageDialog(null, "pin number only can occupied with number","Error",JOptionPane.ERROR_MESSAGE);
			return false;
		}else if(pin.length()>6 ||pin.length()<6) {
			JOptionPane.showMessageDialog(null, "pincode must be 6 digit","Error",JOptionPane.ERROR_MESSAGE);
			return false;
		}else {
			return true;
		}
		
	}
	public static boolean mobileChecking(String mobile) {
		if(Validation.stringContainsString(mobile)==false) {
			
			JOptionPane.showMessageDialog(null, "mobile number only can occupied with number","Error",JOptionPane.ERROR_MESSAGE);
			return false;
		}else if(mobile.length()>10 ||mobile.length()<10) {
			JOptionPane.showMessageDialog(null, "mobile number must be 10 digit","Error",JOptionPane.ERROR_MESSAGE);
			return false;
		}else {
			return true;
		}
		
		
	}
public static boolean emailChecking(String email) {
	if((email.endsWith("@gmail.com")||email.endsWith("@outlook.com")||email.endsWith("@hotmail.com"))&&((email.startsWith("@")==false))) {
		return true;
	}else{
		JOptionPane.showMessageDialog(null, "Invalid email id","Error",JOptionPane.ERROR_MESSAGE);
		return false;
	}
		
}
	public static boolean studentValidation(String name, String father, String address, String pincode, String mobile, String email) {
		 if(nameFieldChecking(name,"Name")==false) {
			 return false;
		 }else if(nameFieldChecking(father,"Father name")==false){
			 return false;
		 }else if(addressFieldChecking(address,"Address")==false){
			return false;
		 }else if(pincodeChecking(pincode)==false) {
			 return false;
		 }else if(mobileChecking(mobile)==false) {
			 return false;
		 }else if(emailChecking(email)==false) {
			 return false;
		 }
		return true;
		
	}
	
	public static boolean facultyValidation(String name,String mobile,String address,String designation,String qualification,String email,String area) {
		if(nameFieldChecking(name,"Name")==false) {
			 return false;
		 }else if(mobileChecking(mobile)==false) {
			 return false;
		 }else if(addressFieldChecking(address,"Address")==false){
				return false;
		 }else if(addressFieldChecking(designation,"designation")==false){
				return false;
		 }else if(addressFieldChecking(qualification,"qualification")==false){
				return false;
		 }else if(addressFieldChecking(area,"Area of Interest")==false){
				return false;
		 }else if(emailChecking(email)==false) {
			 return false;
		 }
		
		return true;
		
	}
	public static boolean adminValidation(String name,String mobile,String address,String designation,String qualification,String email) {
		if(nameFieldChecking(name,"Name")==false) {
			 return false;
		 }else if(mobileChecking(mobile)==false) {
			 return false;
		 }else if(addressFieldChecking(address,"Address")==false){
				return false;
		 }else if(addressFieldChecking(designation,"designation")==false){
				return false;
		 }else if(addressFieldChecking(qualification,"qualification")==false){
				return false;
		 }else if(emailChecking(email)==false) {
			 return false;
		 }
		
		return true;
		
	}

}
