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
package agent.dbgeng.jna.dbgeng.dataspaces;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import agent.dbgeng.jna.dbgeng.sysobj.WrapIDebugSystemObjects4;

public class WrapIDebugDataSpaces4 extends WrapIDebugDataSpaces3 implements IDebugDataSpaces4 {
	public static class ByReference extends WrapIDebugSystemObjects4
			implements Structure.ByReference {
	}

	public WrapIDebugDataSpaces4() {
	}

	public WrapIDebugDataSpaces4(Pointer pvInstance) {
		super(pvInstance);
	}
}
