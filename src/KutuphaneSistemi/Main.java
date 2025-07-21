package KutuphaneSistemi;// File: src/KutuphaneSistemi.Main.java
        // KutuphaneSistemi.Main.java
        import java.util.Scanner;

        public class Main {
            public static void main(String[] args) {
                Library library = new Library();
                library.addBook(new Book(1, "Sefiller"));
                library.addBook(new Book(2, "Suç ve Ceza"));
                library.addStudent(new Student(1, "Ali"));
                library.addStudent(new Student(2, "Ayşe"));

                Scanner scanner = new Scanner(System.in);
                while (true) {
                    System.out.println("1- Kitapları Listele\n2- Kitap Ödünç Al\n3- Öğrenci Kitap Geçmişi\n4- Kitap İade Et\n0- Çıkış");
                    int secim = scanner.nextInt();
                    if (secim == 0) break;
                    switch (secim) {
                        case 1:
                            library.listBooks();
                            break;
                        case 2:
                            System.out.print("Öğrenci ID: ");
                            int sid = scanner.nextInt();
                            System.out.print("Kitap ID: ");
                            int bid = scanner.nextInt();
                            if (library.borrowBook(sid, bid)) {
                                System.out.println("Kitap ödünç alındı.");
                            } else {
                                System.out.println("İşlem başarısız.");
                            }
                            break;
                        case 3:
                            System.out.print("Öğrenci ID: ");
                            int stid = scanner.nextInt();
                            library.showStudentHistory(stid);
                            break;
                        case 4:
                            System.out.print("Öğrenci ID: ");
                            int sidReturn = scanner.nextInt();
                            System.out.print("Kitap ID: ");
                            int bidReturn = scanner.nextInt();
                            if (library.returnBook(sidReturn, bidReturn)) {
                                System.out.println("Kitap iade edildi.");
                            } else {
                                System.out.println("İade işlemi başarısız.");
                            }
                            break;
                    }
                    }
                }
            }



