public class Make_RSA_key{
    public static void main(String[] args) {
    	make_key(2,3,2);
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
}