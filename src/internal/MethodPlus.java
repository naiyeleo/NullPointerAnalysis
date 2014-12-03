package internal;

import java.util.List;

import soot.Body;
import soot.SootMethod;
import soot.Type;

/**
 * class MethodPlus is a class represents method which is compatible with both
 * sootMethod and the method we use.
 * 
 * @author Yingqi
 * 
 */
public class MethodPlus {
	private String methodName;
	private List<Type> parameterSootTypes;
	private String className;
	private SootMethod sootMethod;
	//Q4: can sootmethod abandoned?

	/**
	 * initiate method
	 * 
	 * @param methodName
	 * @param parameterSootTypes
	 */
	public MethodPlus(String methodName, String className,
			List<Type> parameterSootTypes, SootMethod sootMethod) {
		this.methodName = methodName;
		this.className = className;
		this.parameterSootTypes = parameterSootTypes;
		this.sootMethod = sootMethod;
	}

	/**
	 * get method name.
	 * 
	 * @return method name
	 */
	public String getMethodName() {
		return methodName;
	}

	/**
	 * get class name.
	 * 
	 * @return class name
	 */
	public String getclassName() {
		return className;
	}

	/**
	 * get parameters in soot types.
	 * 
	 * @return parameters in soot types
	 */
	public List<Type> getParameterSootTypes() {
		return parameterSootTypes;
	}
	
	public SootMethod getSootmethod(){
		return sootMethod;
	}

	@Override
	public String toString() {
		String methodString =className+"."+ methodName;
		for (Type parameterSootType : parameterSootTypes) {
			methodString =methodString + '\t' + parameterSootType.toString();
		}
		return methodString;
	}
	
	@Override
	public boolean equals(Object object){
		if(! (object instanceof MethodPlus)){
			return false;
		}else {
			MethodPlus methodPlus = (MethodPlus) object;
			return this.getSootmethod().equals(methodPlus.getSootmethod())&&this.className.equals(methodPlus.className);
		}
	}
}
