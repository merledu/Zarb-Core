package riscv
import chisel3._
import chisel3.core
class Top extends Module{
val io=IO(new Bundle{
	//val Instruction=Input(UInt(32.W))
	//val PC=Input(UInt(32.W))
	val out=Output(SInt(32.W))
})
	val pcc=Module(new PC)
	val inst=Module(new Instructionmemory)
	val control=Module(new Control)
	val registerfile=Module(new Registerfile)
	val imm_generation=Module(new Immediategeneration)
	val alucontrol=Module(new Alucontrol)
	val alu=Module(new Alu)
	val jalrr=Module(new Jalrtarget)
	val data=Module(new Datamemory)

	data.io.in_Aluoutput:=(alu.io.Aluout(9,2)).asUInt
	data.io.in_rs2out:=registerfile.io.out_rs2
	data.io.in_controlmemwrite:=control.io.out_memwrite
	data.io.in_controlmemread:=control.io.out_memread
	
	when(control.io.out_memtoreg==="b1".U){
		registerfile.io.in_writedata:=data.io.out_datamemory
	}.elsewhen(control.io.out_memtoreg==="b0".U){
		registerfile.io.in_writedata:=alu.io.Aluout
	}.otherwise{
		registerfile.io.in_writedata:=DontCare
	}
	
	jalrr.io.in_rs1out:=registerfile.io.out_rs1
	when(control.io.out_extend_sel==="b00".U){
		jalrr.io.in_immed :=imm_generation.io.i_type
	}.elsewhen(control.io.out_extend_sel==="b01".U){
		jalrr.io.in_immed :=imm_generation.io.s_type
	}.elsewhen(control.io.out_extend_sel==="b10".U){
		jalrr.io.in_immed :=imm_generation.io.u_type
	}.otherwise{
		jalrr.io.in_immed :=DontCare
	}

	inst.io.wrAddr:=pcc.io.pcout(11,2)
	val instruction=inst.io.rdData
	pcc.io.input:=pcc.io.pc4out

	control.io.in_opcode:=instruction(6,0)
	registerfile.io.in_regwrite:=control.io.out_regwrite
	registerfile.io.in_rs1:=instruction(19,15)
	registerfile.io.in_rs2:=instruction(24,20)
	registerfile.io.in_rd:=instruction(11,7)
	imm_generation.io.instruction:=instruction
	imm_generation.io.pc:=pcc.io.pcout
	alucontrol.io.funct3:=instruction(14,12)
	alucontrol.io.funct7:=instruction(30)
	alucontrol.io.aluop:=control.io.out_Aluop
	alu.io.in_alucontrol:=alucontrol.io.alucontoutput
	
	io.out:=registerfile.io.out_rs1
	when(control.io.out_operand_B_sel==="b1".U){
		when(control.io.out_extend_sel==="b00".U){
			alu.io.in_B :=imm_generation.io.i_type
		}.elsewhen(control.io.out_extend_sel==="b01".U){
			alu.io.in_B :=imm_generation.io.u_type
		}.elsewhen(control.io.out_extend_sel==="b10".U){
			alu.io.in_B :=imm_generation.io.s_type
		}.otherwise{
			alu.io.in_B :=DontCare
		}
	}.elsewhen(control.io.out_operand_B_sel==="b0".U){
		alu.io.in_B:=registerfile.io.out_rs2
	}.otherwise{
		alu.io.in_B:=DontCare
	}
	when(control.io.out_operand_A_sel==="b00".U ||control.io.out_operand_A_sel==="b11".U  ){
		alu.io.in_A:=registerfile.io.out_rs1
	}.elsewhen(control.io.out_operand_A_sel==="b10".U){
		alu.io.in_A:=pcc.io.pc4out.asSInt
	}.otherwise{
		alu.io.in_A:=DontCare
	}
	val andbranch=control.io.out_branch==="b1".U & alu.io.Alubranchout==="b1".U	
	when(control.io.out_next_PC_sel==="b00".U){
		pcc.io.input:=pcc.io.pc4out
	}.elsewhen(control.io.out_next_PC_sel==="b01".U){
		when(andbranch==="b1".U){
			pcc.io.input:=imm_generation.io.sb_type.asUInt
		}.elsewhen(andbranch==="b0".U){
			pcc.io.input:=pcc.io.pc4out
		}.otherwise{
			pcc.io.input:=DontCare
		}
	}.elsewhen(control.io.out_next_PC_sel==="b10".U){
		pcc.io.input:=imm_generation.io.uj_type.asUInt
	}.elsewhen(control.io.out_next_PC_sel==="b11".U){
		pcc.io.input:=jalrr.io.outjalr.asUInt
		
	}.otherwise{
		pcc.io.input:=DontCare
	}
					
}
