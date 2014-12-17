package dispatcher;

import internal.MethodPlus;
import internal.UnitPlus;

import java.io.FileNotFoundException;
import java.util.List;


import java.util.Map;

import java_cup.internal_error;
import soot.Unit;
import soot.Value;
import soot.toolkits.graph.UnitGraphPlus;

/**
 * 
 * @author Yingqi
 *
 */
public interface Dispatcher {
	/**
	 * gets the predecessors of a unit in a complete control flow graph with all
	 * methods
	 * 
	 * @param unit
	 * @return
	 */
	public List<UnitPlus> getPredecessors(UnitPlus unitPlus);

	/**
	 * gets the call site based on the stack trace There are two choices. If the
	 * method overload is considered, then the first element of the list is the
	 * calling method. The second choice is to get all the methods which share
	 * the same name of the calling method.
	 * 
	 * @param unit
	 * @param stackTrace
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws FileNotFoundException 
	 */
	public UnitPlus getStackTraceCallSiteOfMethod(MethodPlus methodPlus,
			StackTraceElement[] stackTrace, int indexOfStackTrace) throws ClassNotFoundException, FileNotFoundException;

	/**
	 * gets the exit units of a method
	 * 
	 * @param methodName
	 * @return
	 */
	public UnitPlus getExitUnitPlus(MethodPlus rteMethod);
	
	/**
	 * gets the entry units of a method
	 * 
	 * @param methodName
	 * @return
	 */
	public UnitPlus getEntryUnitPlus(MethodPlus rteMethod);

	/**
	 * get method name where the unit belongs
	 * 
	 * @return
	 */
	public MethodPlus getMethod(UnitPlus unitPlus);

	/**
	 * return true if the unit is a unit in other methods that call this method.
	 * As there is no entry in the unit graph, so we have to use call sites(the
	 * first call sites) to represent entries i.e. 24a, 10a.
	 * 
	 * @param unit
	 * @return
	 */
	public boolean isEntry(UnitPlus unitPlus);

	/**
	 * return true if the unit is a unit that call other methods. We have to use
	 * call sites(the second call sites) to represent entries i.e. 24b, 10b.
	 * 
	 * @param unit
	 * @return
	 */
	public boolean isCall(UnitPlus unitPlus);
	
	/**
	 * return true if the unit is a definition unit or identity statement.
	 * 
	 * @param unit
	 * @return
	 */
	public boolean isTransform(UnitPlus unitPlus);
	
	/**
	 * get relationship between method plus and unit graph plus
	 * @return
	 */
	public Map<MethodPlus, UnitGraphPlus> getMethodToUnitGraphPlus();
	
	/**
	 * get relationship between stack trace element and unit
	 * @param stackTrace
	 * @param indexOfStackTrace
	 * @return
	 */
	public List<UnitPlus> StackTraceElementToUnit(StackTraceElement[] stackTrace, int indexOfStackTrace);
	
	/**
	 * get caller a for assigned caller b
	 * @param callB
	 * @return
	 */
	public UnitPlus getCallSitePred(UnitPlus callB);
	
	/**
	 * To determine whether the unitplus is the tail of a method
	 * @param unitPlus
	 * @return
	 */
	public boolean isTailOfMethod(UnitPlus unitPlus);

}
