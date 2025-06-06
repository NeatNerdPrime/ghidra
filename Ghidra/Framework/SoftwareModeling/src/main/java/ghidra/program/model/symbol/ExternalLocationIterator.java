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
package ghidra.program.model.symbol;

import java.util.Iterator;

import util.CollectionUtils;

/**
 * Iterator interface for external locations.
 * 
 * @see CollectionUtils#asIterable
 */
public interface ExternalLocationIterator extends Iterator<ExternalLocation> {

	/**
	 * Returns true if another external location is available with the next() method.
	 */
	@Override
	public boolean hasNext();
	
	/**
	 * Returns the next external location
	 */
	@Override
	public ExternalLocation next();
	
}
