package be.yonicon.gildedrose;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

class ApprovalTest {

    @Test
    void runApprovalTestFor25days() throws IOException {

        String actual = TexttestFixture.capture(new String[]{"25"});

        String expected = new String(Files.readAllBytes(Paths.get("src/test/resources/approval_25.txt")));

        assertThat(actual).isEqualToIgnoringNewLines(expected);
    }
}
