import {Text, View} from 'react-native';
import {
  Description,
  GraphText,
  GraphView,
  SubGraphView,
  Title,
  TokensText,
} from './styles';

interface GraphContainerProps {
  title: string;
  description: string;
  graphText: string;
  tokens: string;
}

export const GraphContainer = ({
  description,
  title,
  graphText,
  tokens,
}: GraphContainerProps) => {
  return (
    <GraphView>
      <View style={{borderBottomWidth: 1, width: '90%'}}>
        <Title>{title}</Title>
        <SubGraphView>
          <GraphText>{graphText}</GraphText>
        </SubGraphView>
      </View>
      <View style={{width: '90%', marginTop: '5%'}}>
        <Description>{description}</Description>
        <TokensText>Tokens received: {tokens}</TokensText>
      </View>
    </GraphView>
  );
};
