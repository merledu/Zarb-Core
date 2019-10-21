package riscv
import chisel3._
class Mux4 extends Module{
 val io=IO(new Bundle{
	val in0=Input(UInt(1.W))
	val in1=Input(UInt(1.W))
	val in2=Input(UInt(1.W))
	val in3=Input(UInt(1.W))
	val sl0=Input(UInt(1.W))
	val sl1=Input(UInt(1.W))
	val out=Output(UInt(1.W))
 })
	val mux1=Module(new Mux())
	val mux2=Module(new Mux())
	val mux3=Module(new Mux())
	mux1.io.i0:= io.in0
	mux1.io.i1:=io.in1
	mux1.io.s0:=io.sl0
	mux2.io.i0:=io.in2
	mux2.io.i1:=io.in3
	mux2.io.s0:=io.sl0
	mux3.io.i0:=mux1.io.o
	mux3.io.i1:=mux2.io.o
	mux3.io.s0:=io.sl1
	io.out:=mux3.io.o	
}
