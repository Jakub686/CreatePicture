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

}