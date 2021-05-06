public class Make_RSA_key{
    public static void main(String[] args) {
    	make_key(311,313);
    	System.out.println(isprime(311));
    	System.out.println(isprime(312));
    	System.out.println(isprime(313));
    	System.out.println((int)(Math.random()*100));
    }
    
    // ����Ű, ����Ű ����� �޼ҵ�. p,q�� ���δٸ� �Ҽ�
    public static void make_key(int p, int q) {
    	
    	// 1. p,q�� ���δٸ� �Ҽ����� �Ǻ�
    	if(p == q) {
    		System.out.println("���� ���� �ԷµǾ����ϴ�");
    		return;
    	} else if(isprime(p) == false) {
    		if(isprime(q) == false) {
    			System.out.println("p,q�� �Ѵ� �Ҽ��� �ƴմϴ�");
        		return;
    		} else {
        		System.out.println("p�� �Ҽ��� �ƴմϴ�");
        		return;
    		}
    	} else if(isprime(q) == false) {
    		System.out.println("q�� �Ҽ��� �ƴմϴ�");
    		return;
    	}
    	// 2�� ����
    	// 3. N = p*q, pi = (p-1)*(q-1)
    	int N = p*q;
    	int pi = (p-1)*(q-1);
    	
    	// 4. pi���� �۰�, pi�� ���μ��� ���� e�� ã��. �̶� e���� �������� �̿��Ͽ� ������ �� ��
    	
    	// �������� r : 0 ~ pi - 1 ������ ����
    	int r = (int)(Math.random()*(pi - 1));
    	
    	// while���� ���� ����
    	int i = 2;
    	int k = pi - r;
    	
    	// ���μ��� ���� e�� ã�� ����
    	while(i < k) {
    		// pi�� k �Ѵ� ������ �����μ��� ������ ���, �׶� k���� ���μ��� e�� �� �� ����
    		if(pi % i == 0 && k % i == 0) {
    			k = k-1;
    			i = 2;
    		} else {
    			i = i + 1;
    		}
    	}	// �̶� k���� ���μ��� ���� e
    	
    	// 5. Extended euclidean algorithm�� �̿�, de �� 1 (mod pi)�� �����ϴ� d�� ã�´�.
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