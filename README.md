# DesignPatterns
DesignPatterns learning

proxy : JDK And ciglib 
	difference:
		JDK proxy transfer a reference that created by user,so I think user will be easy to modify attributes that had set method or parameter constructor before compile.
		Ciglib proxy transfer a reference that created by Ciglib,so I think user can't modify attributes anyway before compile.But user maybe use method that define method with parameters what we want to modify during runtime.
	same:
		It's the same way that use bytecode reassembly to implement the dynamic proxy.
