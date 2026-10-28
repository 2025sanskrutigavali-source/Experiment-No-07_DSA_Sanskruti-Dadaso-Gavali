import java.util.Scanner;

class Node {
    String name;
    Node next;

    Node(String name) {
        this.name = name;
        this.next = null;
    }
}

class CircularList {
    Node head = null;

    void insert(String name) {
        Node newNode = new Node(name);

        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node temp = head;

            while (temp.next != head) {
                temp = temp.next;
            }

            temp.next = newNode;
            newNode.next = head;
        }

        System.out.println("Player added.");
    }

    void delete() {
        if (head == null) {
            System.out.println("No players in the game.");
            return;
        }

        if (head.next == head) {
            System.out.println("Removed: " + head.name);
            head = null;
            return;
        }

        Node temp = head;

        while (temp.next != head) {
            temp = temp.next;
        }

        System.out.println("Removed: " + head.name);
        temp.next = head.next;
        head = head.next;
    }

    void display() {
        if (head == null) {
            System.out.println("No players in the game.");
            return;
        }

        Node temp = head;

        System.out.println("Players and their turns:");

        do {
            System.out.println(temp.name);
            temp = temp.next;
        } while (temp != head);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CircularList list = new CircularList();
        int choice;

        do {
            System.out.println("\n1. Add Player");
            System.out.println("2. Remove Player");
            System.out.println("3. Display Players");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter player name: ");
                    String name = sc.nextLine();
                    list.insert(name);
                    break;

                case 2:
                    list.delete();
                    break;

                case 3:
                    list.display();
                    break;

                case 4:
                    System.out.println("Game ended.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);

        sc.close();
    }
}
