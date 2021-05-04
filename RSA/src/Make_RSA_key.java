public class Make_RSA_key{
    public static void main(String[] args) {
    	make_key(2,3,2);
    	System.out.println(isprime(311));
    	System.out.println(isprime(312));
    	System.out.println(isprime(313));
    }
    
    // ����Ű, ����Ű ����� �޼ҵ�. p,q�� ���δٸ� �Ҽ�, 0 < r < (p-1)*(q-1)
    public static void make_key(int p, int q, int r) {
    	
    	// 1. p,q�� ���δٸ� �Ҽ����� �Ǻ�
    	// 2. 0 < r < (p-1)*(q-1) �Ǻ�
    	// 3. N = p*q, ��(N)=(p-1)*(q-1)
    	// 4. ��(N)���� �۰�, ��(N)�� ���μ��� ���� e�� ã��. �̶� e���� ���� r�� ���� ������ ����
    	// 5. Extended euclidean algorithm�� �̿�, de �� 1 (mod ��(N))�� �����ϴ� d�� ã�´�.
    	// 6. (N,e)�� ���� Ű, (N,d)�� ���� Ű
    	
    	System.out.println("(N,e) : ���� Ű, (N,d) : ���� Ű");
    }
    
    // �Է¹��� ���� �Ҽ����� �Ǻ��ϴ� �޼ҵ�. ���ϰ��� true : �Ҽ�, false : �Ҽ��� �ƴ�
	public static boolean isprime(int n) {
		if(n < 2) {
			return false; // 1. �Է¹��� ���� 2 �̸� : �Ҽ��� �ƴ�
		} else if(n == 2 || n == 3) {
			return true; // 1. �Է¹��� ���� 2,3 : �Ҽ�
		} else {
			int i = 2;
			while(i < n/2 + 1) { // 3. 3���� ū �����̸� �Ǻ�. n�� n/2 + 1���� ���� ��� ���� �������� ����
				if(n % i == 0) {
					return false;
				} else {
					i = i + 1;
				}
			}
			return true;
		}
    }
    
}