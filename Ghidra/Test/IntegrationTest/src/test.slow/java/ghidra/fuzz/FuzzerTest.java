package ghidra.fuzz;

import static org.junit.Assert.*;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import ghidra.app.util.headless.AnalyzeHeadless;
import ghidra.GhidraApplicationLayout;
import ghidra.GhidraJarApplicationLayout;

import ghidra.fuzz.FuzzerTestImplementation.FuzzerTestDataSource;

public class FuzzerTest {

	//@Test
	@ParameterizedTest(name = "[{index}] {0}")
  	@FuzzerTestDataSource("fuzzer_classes.xml")
	public void fuzzTest(Path testFilePath) throws Exception {

		String outputDir = "/data/work/fuzzflesh/coverage/ghidra";
		String program = testFilePath.toString();
		String headlessPath = "/data/dev/fuzzflesh/src/fuzzflesh/harness/c";
		String headlessScriptName = "DecompileHeadless.java";
		String outputProgramName = outputDir + "/decomp_prog.c";

		String[] args = {outputDir, 
			"Project", 
			"-import",
			program,
			"-overwrite",
			"-scriptPath", 
			headlessPath,
			"-postScript",
			headlessScriptName, 
			outputProgramName};

		GhidraApplicationLayout layout = new GhidraApplicationLayout();

		new AnalyzeHeadless().launch(layout, args);

	}
}