import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class DeleteDuplication {

    private static final Logger log = LogManager.getLogger(Logger.class);
    private List<Integer> array = new ArrayList<>();
    private final Scanner sc;

    public DeleteDuplication() {
        this.sc = new Scanner(System.in);
    }

    public void addition() {
        System.out.println("Enter the size of the array:");
        int size = this.sc.nextInt();
        if (size == 0) {
            log.warn("Size must be greater than 0!");
            log.error("Size must be greater than 0!");
            log.fatal("Size must be greater than 0!");
        } else {
            System.out.println("Enter the elements of the array:");

            for (int i = 0; i < size; ++i) {
                this.array.add(this.sc.nextInt());
            }
        }
    }

    public void addElement(int num) {
        this.array.add(num);
    }

    public int getSize() {
        log.info("Array size: {}", this.array.size());
        System.out.println("Array size = " + this.array.size());
        return this.array.size();
    }

    public boolean isEmpty() {
        if (this.array.isEmpty()) {
            log.warn("Array is empty!");
            System.out.println("The array is empty.");
        } else {
            log.info("The array is not empty.");
            System.out.println("The array is not empty.");
        }

        return this.array.isEmpty();
    }

    public List<Integer> delete() {
        if (array.size() == 0) {
            log.warn("Size = 0!");
            log.error("Size = 0!");
            throw new IllegalArgumentException();
        } else {
            log.info("Your array: {}", this.array.toString());
            System.out.println("The array created is:" + this.array.toString());
            this.array = new ArrayList<>(new HashSet<>(this.array));
            log.info("Your array after deleting: {}", this.array.toString());
            System.out.println("Array after removing elements:" + this.array.toString());
            return this.array;
        }
    }

    public static void main(String[] args) {
        DeleteDuplication user = new DeleteDuplication();
        user.addition();
        user.isEmpty();
        user.delete();
    }
}
