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
package agent.dbgmodel.jna.dbgmodel.debughost;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.platform.win32.Variant.VARIANT;
import com.sun.jna.platform.win32.WinNT.HRESULT;

public class WrapIDebugHostConstant extends WrapIDebugHostBaseClass implements IDebugHostConstant {
	public static class ByReference extends WrapIDebugHostConstant
			implements Structure.ByReference {
	}

	public WrapIDebugHostConstant() {
	}

	public WrapIDebugHostConstant(Pointer pvInstance) {
		super(pvInstance);
	}

	@Override
	public HRESULT GetValue(VARIANT.ByReference value) {
		return _invokeHR(VTIndicesX.GET_VALUE, getPointer(), value);
	}

}
