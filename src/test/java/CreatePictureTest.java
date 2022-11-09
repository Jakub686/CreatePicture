import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CreatePictureTest {

    private CreatePicture createPicture;

    @BeforeEach
    public void setUp() {
        createPicture = new CreatePicture();
    }

    @Test
    @DisplayName("Fist step")
    void sizeTest() {

        Assertions.assertAll(() -> assertEquals(1, createPicture.size(1)),
                () -> assertEquals(3, createPicture.size(2)),
                () -> assertEquals(5, createPicture.size(3)),
                () -> assertEquals(7, createPicture.size(4)));
    }

    @Test
    void initializeArrayTest() {
        //given
        int n = 3;
        int[][] arr = new int[createPicture.size(n)][createPicture.size(n)];
        int[][] expected = {{3,3,3,3,3},{3,3,3,3,3},{3,3,3,3,3},{3,3,3,3,3},{3,3,3,3,3}};
        expected[n - 1][n - 1] = 1;

        //when
        int[][] result = createPicture.initializeArray(arr, n);

        //then
        Assertions.assertArrayEquals(expected,result);
    }

    @Test
    void subtract() {
        //given
        int n = 3;
        int m = createPicture.size(n);
        int[][] arr = new int[m][m];
        arr = createPicture.initializeArray(arr, n);
        int[][] expected = {{3,3,3,3,3},{3,2,2,2,3},{3,2,1,2,3},{3,2,2,2,3},{3,3,3,3,3}};

        //when
        int[][] result = createPicture.subtract(arr, n,m);

        //then
        Assertions.assertArrayEquals(expected,result);
    }
}