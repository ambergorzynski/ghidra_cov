package ghidra.program.fuzz;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import ghidra.app.util.headless.AnalyzeHeadless;
import ghidra.GhidraApplicationLayout;
import ghidra.GhidraJarApplicationLayout;

public class FuzzerTest {

	@Test
	public void fuzzTest() throws Exception {

		String outputDir = "/data/work/fuzzflesh/coverage/ghidra";
		String program = "/data/work/fuzzflesh/coverage/ghidra/prog_0.o";
		String headlessPath = "/data/dev/fuzzflesh/src/fuzzflesh/harness/c";
		String headlessScriptName = "DecompileHeadless.java";
		String outputProgramName = "/data/work/fuzzflesh/coverage/ghidra/decomp_prog.c";

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