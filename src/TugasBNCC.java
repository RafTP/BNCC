import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TugasBNCC {
	static ArrayList<String> ALnama = new ArrayList<>();
	static ArrayList<String> ALjenis = new ArrayList<>();
	static ArrayList<String> ALjabatan = new ArrayList<>();
	static ArrayList<String> ALid = new ArrayList<>();
	static ArrayList<Double> ALgaji = new ArrayList<>();
	static Scanner scan = new Scanner(System.in);
	static String input = "";
	static String jabatan = "";
	static String kelamin = "";
	static double gaji = 0.0;
	static Random random = new Random();
	static String id = "" + (char) (random.nextInt(26) + 'A') + (char) (random.nextInt(26) + 'A') +"-" +random.nextInt(10) + random.nextInt(10) + random.nextInt(10) + random.nextInt(10);
	static ArrayList<String> ALmanager = new ArrayList<>();
	static ArrayList<String> ALsupervisor = new ArrayList<>();
	static ArrayList<String> ALadmin = new ArrayList<>();
	public TugasBNCC() {

	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		int menu = 0;
		System.out.println("Menu");
		System.out.println("================");
		System.out.println("1. Insert Data Karyawan");
		System.out.println("2. View Data Karyawan");
		System.out.println("3. Update Data Karyawan");
		System.out.println("4. Delete Data Karyawan");
		try {
			System.out.print("Choose :");
			menu = scan.nextInt();
		} catch (Exception e) {
		}
		scan.nextLine();

		switch (menu) {
		case 1:
			insert();
			break;

		case 2:
			view();
			break;

		case 3:
			update();
			break;

		case 4:
			delete();
			break;
		}
	}

	public static void insert() {



		do {
			System.out.print("Input nama karyawan [=> 3]: ");
			input = scan.nextLine();
		} while (input.length() < 3);
		do {
			System.out.print("Input jenis kelamin [Laki-Laki | Perempuan] (Case Sensitive): ");
			kelamin = scan.nextLine();
		} while (!kelamin.equals("Laki-Laki") && !kelamin.equals("Perempuan"));
		do {
			System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
			jabatan = scan.nextLine();
		} while (!jabatan.equals("Manager") && !jabatan.equals("Supervisor") && !jabatan.equals("Admin"));
		System.out.println("Berhasil menambahkan karyawan dengan id " + id);

		if (jabatan.equals("Manager")) {
			gaji = 8000000;
		} else if (jabatan.equals("Supervisor")) {
			gaji = 6000000;
		} else if (jabatan.equals("Admin")) {
			gaji = 4000000;
		}

		ALnama.add(input);
		ALjenis.add(kelamin);
		ALjabatan.add(jabatan);
		ALid.add(id);
		ALgaji.add(gaji);
		
		if (ALmanager.size() % 3 == 0) {
			for (int i = 0; i < ALmanager.size(); i++) {
				ALgaji.set(i,  (ALgaji.get(i) + (gaji * 10 / 100)));
			}
		}
		
		if (ALsupervisor.size() % 3 == 0) {
			for (int i = 0; i < ALsupervisor.size(); i++) {
				ALgaji.set(i,  (ALgaji.get(i) + (gaji * 7.5 / 100)));
			}
		}
		
		if (ALadmin.size() % 3 == 0) {
			for (int i = 0; i < ALadmin.size(); i++) {
				ALgaji.set(i,  (ALgaji.get(i) + (gaji * 5 / 100)));
			}
		}

		System.out.println("ENTER to return");
		scan.nextLine();
		main(null);

	}

	public static void view() {
		if (ALnama.size() == 0) {
			System.out.println("No karyawan found!");
			System.out.println("ENTER to return");
			scan.nextLine();
			main(null);
		}
		
		
		
		for (int i = 0; i < ALnama.size(); i++) {
			for (int j = 0; j < ALnama.size(); j++) {
				if (ALnama.get(j).compareTo(ALnama.get(i)) > 0) {

					
					String temp = ALid.get(i);
					ALid.set(i, ALid.get(j));
					ALid.set(j, temp);

					temp = ALnama.get(i);
					ALnama.set(i, ALnama.get(j));
					ALnama.set(j, temp);

					temp = ALjenis.get(i);
					ALjenis.set(i, ALjenis.get(j));
					ALjenis.set(j, temp);

					Double tempDoub = ALgaji.get(i);
					ALgaji.set(i, ALgaji.get(j));
					ALgaji.set(j, tempDoub);

					temp = ALjabatan.get(i);
					ALjabatan.set(i, ALjabatan.get(j));
					ALjabatan.set(j, temp);
				}
			}
		}
		for (int i = 0; i < ALnama.size(); i++) {
			System.out.println("");
			System.out.println("No                      : " + (i + 1));
			System.out.println("Kode Karyawan           : " + ALid.get(i));
			System.out.println("Nama Karyawan           : " + ALnama.get(i));
			System.out.println("Jenis Kelamin           : " + ALjenis.get(i));
			System.out.println("Jabatan                 : " + ALjabatan.get(i));
			System.out.println("Gaji Karyawan           : " + ALgaji.get(i));
			System.out.println("");

		}
		System.out.println("ENTER to return");
		scan.nextLine();
		main(null);
	}

	public static void update() {
		int nomor = -1;
		for (int i = 0; i < ALnama.size(); i++) {
			for (int j = 0; j < ALnama.size(); j++) {
				if (ALnama.size() == 0) {
					System.out.println("No Karyawan found!");
					System.out.println("ENTER to return");
					main(null);
				} else {
					if (ALnama.get(j).compareTo(ALnama.get(i)) > 0) {

						String temp = ALid.get(i);
						ALid.set(i, ALid.get(j));
						ALid.set(j, temp);

						temp = ALnama.get(i);
						ALnama.set(i, ALnama.get(j));
						ALnama.set(j, temp);

						temp = ALjenis.get(i);
						ALjenis.set(i, ALjenis.get(j));
						ALjenis.set(j, temp);

						Double tempDoub = ALgaji.get(i);
						ALgaji.set(i, ALgaji.get(j));
						ALgaji.set(j, tempDoub);

						temp = ALjabatan.get(i);
						ALjabatan.set(i, ALjabatan.get(j));
						ALjabatan.set(j, temp);
					}

				}
			}
		}
			for (int i = 0; i < ALnama.size(); i++) {
				System.out.println("");
				System.out.println("No                      : " + (i + 1));
				System.out.println("Kode Karyawan           : " + ALid.get(i));
				System.out.println("Nama Karyawan           : " + ALnama.get(i));
				System.out.println("Jenis Kelamin           : " + ALjenis.get(i));
				System.out.println("Jabatan                 : " + ALjabatan.get(i));
				System.out.println("Gaji Karyawan           : " + ALgaji.get(i));
				System.out.println("");
			
		}
	do {
		try {
			System.out.println("Pilih nomor karyawan yang ingin diupdate [1..." + ALnama.size() +"]: ");
			nomor = scan.nextInt();
		} catch (Exception e) {
			
		}scan.nextLine();
	} while (nomor < 1 || nomor > ALnama.size());
	do {
		System.out.print("Input nama karyawan [=> 3]: ");
		input = scan.nextLine();
	} while (input.length() < 3);
	do {
		System.out.print("Input jenis kelamin [Laki-Laki | Perempuan] (Case Sensitive): ");
		kelamin = scan.nextLine();
	} while (!kelamin.equals("Laki-Laki") && !kelamin.equals("Perempuan"));
	do {
		System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
		jabatan = scan.nextLine();
	} while (!jabatan.equals("Manager") && !jabatan.equals("Supervisor") && !jabatan.equals("Admin"));
	

	
	if (jabatan.equals("Manager")){
		gaji = 8000000;
		ALmanager.add(jabatan);
	}
	if (jabatan.equals("Supervisor")){
		gaji = 6000000;
		ALsupervisor.add(jabatan);	
	}
	if (jabatan.equals("Admin")){
		gaji = 4000000;
		ALadmin.add(jabatan);
	}
	ALnama.set((nomor-1), input);
	ALjenis.set((nomor-1), kelamin);
	ALjabatan.set((nomor-1), jabatan);
	ALid.set((nomor-1), id);
	ALgaji.set((nomor-1), gaji);
	
	if (ALmanager.size() % 3 == 0) {
		for (int i = 0; i < ALmanager.size(); i++) {
			ALgaji.set(i,  (ALgaji.get(i) + (gaji * 10 / 100)));
		}
	}
	
	if (ALsupervisor.size() % 3 == 0) {
		for (int i = 0; i < ALsupervisor.size(); i++) {
			ALgaji.set(i,  (ALgaji.get(i) + (gaji * 7.5 / 100)));
		}
	}
	
	if (ALadmin.size() % 3 == 0) {
		for (int i = 0; i < ALadmin.size(); i++) {
			ALgaji.set(i,  (ALgaji.get(i) + (gaji * 5 / 100)));
		}
	}
	System.out.println("Karyawan berhasil diupdate");
	System.out.println("");
	System.out.println("ENTER to return");
	scan.nextLine();
	main(null);
	}
	public static void delete() {
		int hapus = -1;
		for (int i = 0; i < ALnama.size() - 1; i++) {
			for (int j = i + 1; j < ALnama.size(); j++) {
				
				if (ALnama.size() == 0) {
					System.out.println("No Karyawan found!");
					System.out.println("ENTER to return");
					main(null);
				} else {
					if (ALnama.get(i).compareToIgnoreCase(ALnama.get(j)) > 0) {

						String temp = ALid.get(i);
						ALid.set(i, ALid.get(j));
						ALid.set(j, temp);

						temp = ALnama.get(i);
						ALnama.set(i, ALnama.get(j));
						ALnama.set(j, temp);

						temp = ALjenis.get(i);
						ALjenis.set(i, ALjenis.get(j));
						ALjenis.set(j, temp);

						Double tempDoub = ALgaji.get(i);
						ALgaji.set(i, ALgaji.get(j));
						ALgaji.set(j, tempDoub);

						temp = ALjabatan.get(i);
						ALjabatan.set(i, ALjabatan.get(j));
						ALjabatan.set(j, temp);
					}

				}
			}
		}
			for (int i = 0; i < ALnama.size(); i++) {
				System.out.println("");
				System.out.println("No                      : " + (i + 1));
				System.out.println("Kode Karyawan           : " + ALid.get(i));
				System.out.println("Nama Karyawan           : " + ALnama.get(i));
				System.out.println("Jenis Kelamin           : " + ALjenis.get(i));
				System.out.println("Jabatan                 : " + ALjabatan.get(i));
				System.out.println("Gaji Karyawan           : " + ALgaji.get(i));
				System.out.println("");
			
		}
	do {
		try {
			System.out.println("Pilih nomor karyawan yang ingin dihapus [1..." + ALnama.size() +"]: ");
			hapus = scan.nextInt();
		} catch (Exception e) {
			
		}scan.nextLine();
	} while (hapus < 1 || hapus > ALnama.size());
		
	ALnama.remove(hapus-1);
	ALjenis.remove(hapus-1);
	ALjabatan.remove(hapus-1);
	ALid.remove(hapus-1);
	ALgaji.remove(hapus-1);
		
	System.out.println("Karyawan berhasil dihapuss");	
	System.out.println("ENTER to return");
	scan.nextLine();	
	main(null);		
	}

}