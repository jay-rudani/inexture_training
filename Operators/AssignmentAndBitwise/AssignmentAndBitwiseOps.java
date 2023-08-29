package Operators.AssignmentAndBitwise;

class AssignmentAndBitwiseOps {

    public static void main(String[] args) {

        int x = 10;
        System.out.println("Addition : 10 + 2 : " + (x += 2));
        System.out.println("Subtraction : 12 - 2 : " + (x -= 2));
        System.out.println("Multiplication : 10 * 3 : " + (x *= 3));
        System.out.println("Division : 30 / 3 : " + (x /= 3));
        System.out.println("Remainder : 10 % 4 : " + (x %= 4));

        // 2 : 0010
        // 1 : 0001
        // & : 0000 = 0
        System.out.println("Bitwise AND : 2 & 1 : " + (x &= 1));

        // 0 : 0000
        // 6 : 0110
        // | : 0110 = 6
        System.out.println("Bitwise OR : 0 & 6 : " + (x |= 6));

        // 6 : 0110
        // 3 : 0011
        // ^ : 0101 = 5
        System.out.println("Bitwise XOR : 6 ^ 3 : " + (x ^= 3));

        // 5 : 0101
        // << : 1010 = 10
        System.out.println("Left shift : " + (x <<= 1));

        // 10 : 1010
        // >> : 0101 = 5
        System.out.println("Right shift : " + (x >>= 1));
    }
}
