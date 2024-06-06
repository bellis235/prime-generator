import java.util.LinkedList;
import java.lang.Math;
import java.util.Random;
public class Assignment7 {
    public static class Prime {
        LinkedList<Integer> newLinkedList = new LinkedList<>();
        public Prime(int max) {
            boolean maxSize[] = new boolean[max+1];
            for (int i = 0; i < maxSize.length; i++) {
                maxSize[i] = true;
            }
            for (int i = 2; i <= (Math.sqrt(max)); i++) {
                if (maxSize[i]) {
                    for (int j = i * i; j <= max; j += i) {
                        maxSize[j] = false;
                    }
                }
            }
            for (int i = 2; i <= max; i++) {
                if (maxSize[i]) {
                    newLinkedList.add(i);
                }
            }
        }
        public boolean isPrime(int num) {
            for (int value : newLinkedList) {
                if (num == value) {
                    return true;
                }
            }
            return false;
        }
        public int getPrime(int index) {
            return newLinkedList.get(index);
        }
    }
        public static int findFactor(int target, Prime primeObject) {
            for (int i = 0; i < primeObject.newLinkedList.size(); i++) {
                if (target % primeObject.getPrime(i) == 0) {
                    return primeObject.getPrime(i);
                }
            }
            if (target < 2) {
                return -1;
            }
            return -1;
        }
    public static void main(String[] args) {
        int constant = 10000;
        Random rand = new Random();
        int randomNumber = 0;
        Prime prime = null;
        do {
            randomNumber = rand.nextInt(constant);
            prime = new Prime(randomNumber);
        } while (randomNumber < 2 || prime.isPrime(randomNumber));
        System.out.println("What primes make up " + randomNumber + ": ");
        int target = randomNumber;
        boolean isFirstFactor = true;

        while (target >= 2) {
            int factor = findFactor(target, prime);
            if (isFirstFactor) {
                System.out.print(factor);
                isFirstFactor = false;
            } else {
                System.out.print(" x " + factor);
            }
            target /= factor;
        }
    }
}
