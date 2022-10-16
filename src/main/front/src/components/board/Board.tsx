import React from 'react';
import Tile from './Tile';
import styled from 'styled-components';

const BoardWrapper = styled.div`
    display: grid;
    grid-auto-rows: min-content;
    padding: 30px;
`;

const RowStyle = styled.div`
    display: flex;
    justify-content: center;
`;

const boardSize = 15;
const verticalAxis =["1","2","3","4","5","6","7","8","9","10","11","12","13","14","15"].reverse();
const horizontalAxis = ["A","B","C","D","E","F","G","H","I","J","K","L","M","N","O"];
const rowLengths = [5, 7, 9, 11, 13, 15, 15, 15, 15, 15, 13, 11, 9, 7, 5];

const Board = () => {

    const board = [];

    for(let i = 0; i < boardSize; i++) {
        let row = [];
        let verticalDim = (boardSize - rowLengths[i]) / 2;
        
        for(let j = 0; j < rowLengths[i]; j++) {
            let tileColor = '#3F4E4F';
            if((verticalDim + i + j) % 2 !== 0) tileColor = '#2C3639';
            row.push(
                    <Tile
                        tileColor={tileColor}
                        dimX={horizontalAxis[verticalDim + j]} 
                        dimY={verticalAxis[i]}
                    />
                );
        }

        board.push(<RowStyle>{row}</RowStyle>);
    }

    return (
        <BoardWrapper>
            {board}
        </BoardWrapper>
    )
}

export default Board;