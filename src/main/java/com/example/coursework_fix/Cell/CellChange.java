//package com.example.demo;
//
//public class CellChange {
//    private Group root;
//    private Text textClass;
//
//    public  CellChange {
//        private Group root;
//        private Text textclass;
//
//        public CellChange(Group root , Text textClass){
//            this.root = root;
//            this.textclass=textClass;
//        }
//        void changeCell(Cell cell) {
//            //the below 2 lines to let text class work
//            ChangingText text = new ChangingText();
//            text.changeTwoText(textClass, cell.getTextClass());
//            root.getChildren().remove(cell.getTextClass());
//            root.getChildren().remove(textClass);
//
//            if (!cell.getTextClass().getText().equals("0")) {
//                root.getChildren().add(cell.getTextClass());
//            }
//            if (!textClass.getText().equals("0")) {
//                root.getChildren().add(textClass);
//            }
//            setColor(getNumber());
//            cell.setColor(cell.getNumber());
//        }
//    }
//
//
//}
