/* ###
 * IP: GHIDRA
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ghidra.app.util.bin.format.elf.relocation;

import ghidra.app.plugin.core.reloc.ElfRelocationFixupHandler;
import ghidra.app.util.opinion.ElfLoader;
import ghidra.program.model.address.Address;
import ghidra.program.model.lang.Language;
import ghidra.program.model.lang.Processor;
import ghidra.program.model.listing.Program;
import ghidra.program.model.mem.MemoryAccessException;
import ghidra.program.model.reloc.Relocation;
import ghidra.program.model.reloc.Relocation.Status;
import ghidra.program.model.util.CodeUnitInsertionException;

public class Elfx86_64bitRelocationFixupHandler extends ElfRelocationFixupHandler {

	public Elfx86_64bitRelocationFixupHandler() {
		super(X86_64_ElfRelocationType.class);
	}

	@Override
	public boolean processRelocation(Program program, Relocation relocation, Address oldImageBase,
			Address newImageBase) throws MemoryAccessException, CodeUnitInsertionException {

		if (relocation.getStatus() != Status.APPLIED) {
			return false;
		}

		X86_64_ElfRelocationType type =
			(X86_64_ElfRelocationType) getRelocationType(relocation.getType());
		if (type == null) {
			return false;
		}

		switch (type) {
			case R_X86_64_COPY:
			case R_X86_64_64:
			case R_X86_64_RELATIVE:
			case R_X86_64_RELATIVE64:
			case R_X86_64_GLOB_DAT:
			case R_X86_64_JUMP_SLOT:
			case R_X86_64_GOTPCREL64:
			case R_X86_64_IRELATIVE:
				return process64BitRelocation(program, relocation, oldImageBase, newImageBase);
			default:
				// TODO: Apply bookmark where relocation fixup failed to be processed
				return false;
		}
	}

	@Override
	public boolean handlesProgram(Program program) {
		if (!ElfLoader.ELF_NAME.equals(program.getExecutableFormat())) {
			return false;
		}
		Language language = program.getLanguage();
		if (language.getLanguageDescription().getSize() != 64) {
			return false;
		}
		Processor processor = language.getProcessor();
		return (processor.equals(Processor.findOrPossiblyCreateProcessor("x86")));
	}

}
