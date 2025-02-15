import styled from 'styled-components/native';

export const GraphView = styled.View`
  height: 355;
  width: 351;
  margin-top: 10%;
  background-color: ${({theme}) => theme.palette.secondaryColor};
  border-radius: 20px;
  display: flex;
  align-items: center;
`;

export const SubGraphView = styled.View`
  display: flex;
  height: 200px;
  width: 80%;
  flex-direction: column;
  justify-content: center;
  align-self: center;
`;

export const GraphText = styled.Text`
  color: ${({theme}) => theme.palette.black};
  font-size: 12;
  font-weight: bold;
`;

export const Title = styled.Text`
  margin-top: 5%;
  color: ${({theme}) => theme.palette.black};
`;

export const Description = styled.Text`
  color: ${({theme}) => theme.palette.black};
  font-size: 12;
`;

export const TokensText = styled.Text`
  color: ${({theme}) => theme.palette.black};
  font-size: 20;
  margin-top: 5%;
`;
